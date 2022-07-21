package com.sks.sa.boss.repo;

import org.springframework.stereotype.Repository;

@Repository
public class AppRepositary {
	
//
//	final String GET_DETAILS = "select * from User_Bean where username = :username";
//
//	final String GET_ALL = "select * from USer_Bean";
//
//	final String GET_ALL_EMPLOYEE = "select * from Employee_Bean";
//	
//	final String SAVE_NEW_USER = "insert into NEW_USER(NEW_USER_ID,USER_NAME,USER_MAIL,USER_PASSWORD,USER_CNF_PASSWORD) "
//			+ "values(:id ,:username , :usermail , :userpassword ,:usercnfpassword)";
//
//	@Autowired
//	private NamedParameterJdbcTemplate jdbcTemplate;
//
//	public UserBean getUserDetails(String name) {
//		try {
//			Map map = new HashMap();
//			map.put("username", name);
//			return jdbcTemplate.queryForObject(GET_DETAILS, map, new UserBeanMapper());
//		} catch (Exception e) {
//			throw new AppException("Incorrect Username");
//		}
//
//	}
//
//	public List<EmployeeBean> getAllEmployee() {
//		return jdbcTemplate.query(GET_ALL_EMPLOYEE, new EmployeeMapper());
//
//	}
//
//	public List<UserBean> getAllUser() {
//		return jdbcTemplate.query(GET_ALL, new UserBeanMapper());
//	}
//	
//	public int saveNewuser(final NewUser user) {
//		Map<String,String> mapData = new HashMap<String, String>();
//		mapData.put("id", "1000");
//		mapData.put("username", user.getUserName());
//		mapData.put("usermail", user.getUserEmail());
//		mapData.put("userpassword", user.getUserPassword());
//		mapData.put("usercnfpassword", user.getUserCnfPassword());
//		return jdbcTemplate.update(SAVE_NEW_USER, mapData);
//	}
//
//}
//
//class UserBeanMapper implements RowMapper<UserBean> {
//
//	@Override
//	public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
//		UserBean bean = new UserBean();
//		bean.setId(rs.getLong("id"));
//		bean.setUsername(rs.getString("username"));
//		bean.setPassword(rs.getString("password"));
//		bean.setRole(rs.getString("role"));
//		return bean;
//	}
//
//}
//
//class EmployeeMapper implements RowMapper<EmployeeBean> {
//
//	@Override
//	public EmployeeBean mapRow(ResultSet rs, int rowNum) throws SQLException {
//		EmployeeBean bean = new EmployeeBean();
//		bean.setId(rs.getLong("id"));
//		bean.setEmpName(rs.getString("EMP_NAME"));
//		bean.setEmpMail(rs.getString("emp_Mail"));
//		bean.setEmpPhone(rs.getString("emp_Phone"));
//		bean.setEmpSalary(rs.getDouble("emp_Salary"));
//		bean.setEmpAddress(rs.getString("emp_Address"));
//		// bean.setEmpJoinDt(rs.getDate("empJoinDt"));
//		return bean;
//	}

}