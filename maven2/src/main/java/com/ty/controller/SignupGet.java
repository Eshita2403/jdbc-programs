package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.SignUpDao;

import com.ty.dto.SignUp;

public class SignupGet {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter your email");
		String email = scanner.next();
		System.out.println("enter your password");
		String password = scanner.next();
		SignUpDao pdao = new SignUpDao();
		SignUp signup = pdao.getObj(email, password);
		if (signup != null) {
			System.out.println(signup.getFirstname());
			System.out.println(signup.getLastname());
			System.out.println(signup.getEmail());
			System.out.println(signup.getPassword());
			System.out.println(signup.getPhone());
			System.out.println(signup.getDob());
			System.out.println(signup.getGender());
		}
	}
}
