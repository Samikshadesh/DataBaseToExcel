package com.Hcc.ExportToExcel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan
public class ExcelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelApplication.class, args);
	}

}
