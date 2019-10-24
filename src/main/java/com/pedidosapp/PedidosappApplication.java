package com.pedidosapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PedidosappApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidosappApplication.class, args);
		//System.out.print(new BCryptPasswordEncoder().encode("123"));
		System.out.print(new BCryptPasswordEncoder().encode("123"));
	}
}
