package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootFileUploadDownloadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFileUploadDownloadApplication.class, args);
		System.out.println("File Upload-Download Application running on Port No: 8181...");
	}

}


		// dependencies: jpa, spring web, jdbc, mysql, devtools