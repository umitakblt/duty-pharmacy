package com.umitakbulut.duty_pharmacy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DutyPharmacyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DutyPharmacyApplication.class, args);
	}

}
