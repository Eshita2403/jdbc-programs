package com.ty.controller;

import java.util.Scanner;


import com.ty.dao.SignUpDao;
import com.ty.dto.SignUp;

public class SignupDelete {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter your firstname");
		String firstname = scanner.next();
		SignUpDao sdao = new SignUpDao();
		String result = sdao.deleteObj(firstname);
		System.out.println(result);
	}
	
}
