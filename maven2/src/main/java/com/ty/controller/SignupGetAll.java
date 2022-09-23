package com.ty.controller;

import java.util.List;
import java.util.Scanner;

import com.ty.dao.SignUpDao;
import com.ty.dto.SignUp;


public class SignupGetAll {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SignUpDao pdao = new SignUpDao();
		List<SignUp> l = pdao.getAll();
		System.out.println(l);
	}
	
	
}
