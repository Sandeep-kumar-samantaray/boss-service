//package com.sks.sa.boss.report;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.stereotype.Service;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import net.sf.jasperreports.engine.JRDataSource;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.data.JsonDataSource;
//import net.sf.jasperreports.engine.export.JRCsvExporter;
//import net.sf.jasperreports.engine.export.JRPdfExporter;
//import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
//import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
//import net.sf.jasperreports.export.SimpleExporterInput;
//import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
//import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
//
//@Service	
//public class JasperReportService {
//
//	@Autowired
//	private ResourceLoader resourceLoader;
//	
//	public byte[] exportByObject(Object object, String jasperName , String exportType) throws IOException, JRException {
//		InputStream file = resourceLoader.getResource("classpath:template/jasper/binary"+jasperName+".jasper").getInputStream();
//		ObjectMapper objectMapper = new ObjectMapper();
//		System.out.println("object convert to JSON format :: "+objectMapper.writeValueAsString(object));
//		
//		ByteArrayInputStream inputStream = new ByteArrayInputStream(objectMapper.writeValueAsBytes(object));
//		JRDataSource jsonDataSource = new JsonDataSource(inputStream);
//		
//		JasperPrint jasperPrint = JasperFillManager.fillReport(file, null, jsonDataSource);
//		finalExport(jasperPrint,exportType);
//		return null;
//		
//	}
//	
//	public byte[] finalExport(JasperPrint jasperPrint , String exportType) throws JRException {
//		switch (exportType) {
//		case "pdf":
//			final JRPdfExporter pdfExporter = new JRPdfExporter();  
//			pdfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//			final SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
//			configuration.setCreatingBatchModeBookmarks(true);
//			pdfExporter.setConfiguration(configuration);
//			pdfExporter.exportReport();
//			break;
//		case "csv":
//			final JRCsvExporter csvExporter = new JRCsvExporter();
//			csvExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//			csvExporter.exportReport();
//			break;
//		case "docx":
//			final JRDocxExporter docxExporter = new JRDocxExporter();
//			docxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//			docxExporter.exportReport();
//			break;
//		case "xlsx":
//			final JRXlsxExporter xlsxExporter = new JRXlsxExporter();
//			final List<JasperPrint> jasperPrintList = new ArrayList<>();
//			jasperPrintList.add(jasperPrint);
//			xlsxExporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList));
//			final SimpleXlsxReportConfiguration xlsxConfiguration = new SimpleXlsxReportConfiguration();
//			xlsxConfiguration.setOnePagePerSheet(false);
//			xlsxConfiguration.setDetectCellType(true);
//			xlsxConfiguration.setIgnoreCellBorder(false);
//			xlsxConfiguration.setWhitePageBackground(false);
//			xlsxExporter.setConfiguration(xlsxConfiguration);
//			xlsxExporter.exportReport();
//		default:
//			break;
//		}
//		return null;
//	}
//}
