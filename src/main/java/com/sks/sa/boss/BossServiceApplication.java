package com.sks.sa.boss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.sks.sa.*"})
@EntityScan("com.sks.sa.boss.dm.*")
@Configuration
public class BossServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BossServiceApplication.class, args);
	}
	
//	@Bean
//	private CommandLineRunner runner(UserRepository repo) {
//		return args -> {
//			repo.saveAndFlush(new User(100L, "sandeep", "kuamr", "testMail", "test@1"));
//		};
//		
//	}

}
