package com.cav.spring.service.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@SpringBootApplication(scanBasePackages={"com.cav.spring.service.bank"})
@EnableEurekaClient
public class BankWebServiceApp {
	
	   public static void main(String[] args) {
	        SpringApplication.run(BankWebServiceApp.class, args);
	    }

}
