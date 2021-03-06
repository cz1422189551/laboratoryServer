package com.lq.laboratory;

import com.lq.laboratory.config.ApplicationListenerImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class LaboratoryApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(LaboratoryApplication.class);
        springApplication.addListeners(new ApplicationListenerImpl());
        springApplication.run(args);
    }
}
