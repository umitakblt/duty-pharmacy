package com.umitakbulut.duty_pharmacy;

import com.umitakbulut.duty_pharmacy.config.AppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableConfigurationProperties(value = {AppConfiguration.class})
@EnableFeignClients
public class DutyPharmacyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DutyPharmacyApplication.class, args);
	}

}
