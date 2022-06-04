package com.example.rates;

import com.example.rates.repo.RateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatesApplication.class, args);
	}

	@Bean
	public CommandLineRunner data(RateRepository repository) {
		return (args) -> {
			repository.save(new Rate("EUR",0.88857F,new Date()));
			repository.save(new Rate("JPY",102.17F,new Date()));
			repository.save(new Rate("MXN",19.232F,new Date()));
			repository.save(new Rate("GBP",0.75705F,new Date()));
		};
	}


}
