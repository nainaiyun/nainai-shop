package com.nainai.sidecarphp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@EnableSidecar
@SpringBootApplication
@EnableEurekaClient
public class SidecarphpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SidecarphpApplication.class, args);
	}
}
