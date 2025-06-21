package org.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//스프링 부트의 자동 설정. 스프링 Bean 읽기와 생성을 모두 자동으로 설정
// main메소드의 SpringApplication.run으로 인해 내장 WAS(Web Application Server) 실행.
//@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})

//@EnableJpaAuditing //JPA Auditing활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
