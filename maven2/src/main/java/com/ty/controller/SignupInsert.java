package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.SignUpDao;
import com.ty.dto.SignUp;

public class SignupInsert {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("enter your firstname");
	String firstname = scanner.next();
	System.out.println("enter your lastname");
	String lastname =scanner.next();
	System.out.println("enter your email");
	String email = scanner.next();
	System.out.println("enter your password");
	String password = scanner.next();
	System.out.println("enter your phone number");
	long pnone = scanner.nextLong();
	System.out.println("enter your dob");
	String dob =scanner.next();
	System.out.println("enter your gender");
	String gender = scanner.next();
	
	SignUp signup = new SignUp();
	SignUpDao sdao = new SignUpDao();
	
	signup.setFirstname(firstname);
	signup.setLastname(lastname);
	signup.setEmail(email);
	signup.setPassword(password);
	signup.setPhone(pnone);
	signup.setDob(dob);
	signup.setGender(gender);
	
	SignUp srt = sdao.insertObj(signup);
	System.out.println(srt.getFirstname() + " is Saved");
	
	
	
}
}
