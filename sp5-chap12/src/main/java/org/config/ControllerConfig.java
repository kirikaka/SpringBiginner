package org.config;

import org.controller.RegistController;
import org.controller.SurveyController;
import org.spring.MemberRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Autowired
    private MemberRegisterService memberRegisterService;


    @Bean
    public RegistController registController() {
        RegistController controller = new RegistController();
        controller.setMemberRegisterService(memberRegisterService);
        return controller;
    }
    @Bean
    public SurveyController surveyController() {
        return new SurveyController();
    }

}
