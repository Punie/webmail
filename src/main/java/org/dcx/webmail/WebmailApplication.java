package org.dcx.webmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan (basePackages = {"org.dcx.webmail.entities"})
@EnableJpaRepositories (basePackages = {"org.dcx.webmail.repositories"})
public class WebmailApplication
{
	public static void main (String[] args)
	{
		SpringApplication.run (WebmailApplication.class, args);
	}
}
