package com.github.daos;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.github.dtos.LoginDto;
import com.github.dtos.NewUser;

@Repository
public class LoginRegisterDao {
	
	private JdbcTemplate jt;
	
	public JdbcTemplate getJt() {
		return jt;
	}
	public void setJt(JdbcTemplate jt) {
		System.out.println("Inside Setter : "+jt);
		this.jt = jt;
	}

	public void registerNewUser(NewUser userDto){
		System.out.println("dto ...");
		
		String query ="INSERT INTO `gmailusers`(`firstName`, `lastName`, `password`, `email`)"
				+ "VALUES ('"+userDto.getFirstName()+"','"+userDto.getLastName()+"','"
				+userDto.getPassword()+"','"+userDto.getEmail()+"')";
		jt.update(query);
	}
	
	public boolean loginChectk(LoginDto loginDto){
		String query ="SELECT count(*) FROM `gmailusers` WHERE email='"+loginDto.getEmail()+
				"' AND password='"+loginDto.getPassword()+"' ";
		System.out.println("JT: "+jt);
		int count = jt.queryForInt(query);
		if(count==1){
			String sql = "select firstName from gmailusers where email='"+loginDto.getEmail()+"'";
			loginDto.setUserName((String) jt.queryForObject(sql, String.class));
			return true;
		} else {
			return false;
		}
	}
} 