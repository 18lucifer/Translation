package com.TranslationApi.Translation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TranslationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranslationApplication.class, args);
		System.out.println("IN side main");
	}

}
