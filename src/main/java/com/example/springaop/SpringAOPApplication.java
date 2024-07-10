package com.example.springaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

@SpringBootApplication
public class SpringAOPApplication {
	//feature_conflict
	public static void main(String[] args) {
		SpringApplication.run(SpringAOPApplication.class, args);
		Locale french = new Locale("fr", "FR");
		System.out.println(ResourceBundle.getBundle("i18n", french).getString("hello"));
	}
}
