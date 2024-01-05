package com.abhi.SpringJDBC;

import com.abhi.SpringJDBC.model.Alien;
import com.abhi.SpringJDBC.repository.AlienRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringJdbcApplication.class, args);

		Alien alien = applicationContext.getBean(Alien.class);
		alien.setId(1);
		alien.setName("abcd");
		alien.setTech("java");


		AlienRepository alienRepository = applicationContext.getBean(AlienRepository.class);

		alienRepository.save(alien);

		System.out.println(alienRepository.findAll());
	}
}
