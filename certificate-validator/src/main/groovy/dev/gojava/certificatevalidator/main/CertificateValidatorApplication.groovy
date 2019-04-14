package dev.gojava.certificatevalidator.main

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("dev.gojava.certificatevalidator")
class CertificateValidatorApplication {

	static void main(String[] args) {
		SpringApplication.run(CertificateValidatorApplication, args)
	}

}
