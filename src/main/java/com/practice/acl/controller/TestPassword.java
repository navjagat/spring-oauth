package com.practice.acl.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestPassword {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(6);
		
		String password = "welcome123";
		
		System.out.println(encoder.encode(password));
		System.out.println(encoder.matches(password, "$2a$06$d9.njTX8.u628XQG01ughOPPWa85KAdvByEBUy1YfreYQ5gSqAlN6"));

	}

}
