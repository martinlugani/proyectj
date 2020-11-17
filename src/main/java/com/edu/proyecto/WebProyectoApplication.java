package com.edu.proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class WebProyectoApplication {

	@Autowired
	private BCryptPasswordEncoder passEncoder;

	
	public static void main(String[] args) {
		SpringApplication.run(WebProyectoApplication.class, args);
	}
//	public void run(String... args) throws Exception{
//		String pass1 = "user";
//		String pass2 = "admin";
//		System.out.println("CLAVE USER"+passEncoder.encode(pass1));
//		System.out.println(passEncoder.encode(pass2));
//	}
}
