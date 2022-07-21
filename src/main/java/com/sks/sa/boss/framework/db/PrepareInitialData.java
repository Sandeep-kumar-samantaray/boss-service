package com.sks.sa.boss.framework.db;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sks.sa.boss.dm.bean.Employee;

@Component
public class PrepareInitialData {

	@Autowired
	private EmployeeRepository empRepo;

	@PostConstruct
	public void insertMockData() {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		executorService.execute(new Runnable() {

			@Override
			public void run() {
				try {
					ObjectMapper mapper = new ObjectMapper();
					empRepo.deleteAll();
					Thread.currentThread().setPriority(3);
					File file = ResourceUtils.getFile("classpath:static/Employee_Detail.json");
//					File file = new File("D:\\java_program\\workspace\\Mock_Data\\Employee_Detail.json");
					System.out.println("Current Thread name " + Thread.currentThread().getName());
					List<Employee> empList = mapper.readValue(file, new TypeReference<List<Employee>>() {
					});
					empRepo.saveAll(empList);
					System.out.println("Successfull ");
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					System.out.println("finally");
				}
			}
		});

		//need to work on priority based thread execution 
		//End have to go through multi thread env
		
//		executorService.execute(new Runnable() {
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				List<Employee> empList = empRepo.findAll();
//				Thread.currentThread().setPriority(9);
//				for (int i = 0; i < empList.size(); i++) {
//					System.out.println("Current Thread on update " + Thread.currentThread().getName());
//					Employee employee = empList.get(i);
//					employee.setUpdatedBy("Thread");
//					employee.setUpdatedDate(Calendar.getInstance().getTime());
//				}
//				empRepo.saveAllAndFlush(empList);
//			}
//		});

		executorService.shutdown();
	}
}
