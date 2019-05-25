package dev.gojava.certificatevalidator.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan({
		"dev.gojava.certificatevalidator.controller",
		"dev.gojava.certificatevalidator.data.*",
		"dev.gojava.certificatevalidator.service",
})
public class CertificateValidatorApplication {

	private static Logger LOG = LoggerFactory.getLogger(CertificateValidatorApplication.class);

	public static void main(String[] args) {
		// Configura as propriedades do ambiente
		// TODO Ambiente de DEV - Dont push this to master
//		System.setProperty("spring.devtools.restart.enabled", "false");

		SpringApplication.run(CertificateValidatorApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext appContext) {
		return args -> {
			String[] beans = appContext.getBeanDefinitionNames();
			LOG.debug("Lista de Beans:");
			Arrays.stream(beans).sorted().forEach(LOG::debug);
			LOG.debug("Fim de lista de Beans:");
		};
	}

}
