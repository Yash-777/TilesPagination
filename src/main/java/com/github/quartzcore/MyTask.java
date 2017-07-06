package com.github.quartzcore;

import com.github.daos.EmpDao;

public class MyTask {
	
	private EmpDao edao;
	
	private QuartzEmail email;

	public static int size = 10;

	public void sayHello() {
		System.out.println("Hello !!! ");
		
		int currSize = 0;
		if ((currSize = edao.emp_count()) != size) {
			size = currSize;
			System.out.println("####### Records Changed in DB : "+size);
			email.sendMail();
			
		} else {
			System.out.println("Records not added/removed. "+currSize);
		}
	}
	
	public EmpDao getEdao() {	return edao;	}
	public void setEdao(EmpDao edao) {	this.edao = edao;	}
	
	public QuartzEmail getEmail() {	return email;	}
	public void setEmail(QuartzEmail email) {	this.email = email;	}
}