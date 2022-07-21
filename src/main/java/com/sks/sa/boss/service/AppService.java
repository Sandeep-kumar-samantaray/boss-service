package com.sks.sa.boss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sks.sa.boss.repo.AppRepositary;

@Service
public class AppService {

	@Autowired
	private AppRepositary apprepo;

//	public List<UserBean> getAllrecord() {
//		List<UserBean> allData = apprepo.getAllUser();
//		return allData;
//	}
//
//	public List<EmployeeBean> getAllEmployee() {
//		List<EmployeeBean> allData = apprepo.getAllEmployee();
//		return allData;
//	}
//
//	public Integer addNewUser(final NewUser user) {
//		return apprepo.saveNewuser(user);
//	}
//
//	public String sendsms(String phoneNumber) {
//		String res = generateOtp();
//		sendSMS(res, phoneNumber);
//		return res +" "+phoneNumber;
//	}
//
//	public static String generateOtp() {
//		Double randomNumber = Math.random() * 10000000;
//		String genOtp = randomNumber.toString().substring(1, 6);
//		return genOtp;
//	}
//
//	public static void sendSMS(String res , String phoneNumber) {
//		try {
////			//created on 22-10-2020 valid upto 30 days , 10 msg/day
////			//go to textlocal.in , do register get api , continue the same flow 
////			String apiKey = "apiKey=" + "d/SQUJqDsyA-GDhISKP7uRmmyo8n7CtyZgpcWYqylP";
////			String apiMsg = "&message="+ URLEncoder.encode("Your OTP for change password is : " +res , "UTF-8");
////			String numbers = "&numbers=" + phoneNumber; 
////			String apiURL = "https://api.textlocal.in/send/?" + apiKey + apiMsg + numbers ;
////			
////			URL url = new URL(apiURL);
////			URLConnection urlConnection = url.openConnection();
////			urlConnection.setDoOutput(Boolean.TRUE);
////			
////			BufferedReader bufferedReader  = 
////					new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
////			
////			String line = "";
////			StringBuilder builder = new StringBuilder();
////			while ((line = bufferedReader.readLine()) != null) {
////				builder.append(line).append("\n");
////			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
