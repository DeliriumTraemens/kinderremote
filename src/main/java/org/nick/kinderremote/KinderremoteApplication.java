package org.nick.kinderremote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;

@SpringBootApplication
//@EnableSpringHttpSession
//@EnableJdbcHttpSession

@EnableJpaRepositories
@EnableSpringHttpSession
public class KinderremoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(KinderremoteApplication.class, args);
	}

}
