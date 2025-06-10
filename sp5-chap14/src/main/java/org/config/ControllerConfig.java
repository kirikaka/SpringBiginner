package org.config;

import org.controller.*;
import org.spring.AuthService;
import org.spring.ChangePasswordService;
import org.spring.MemberDao;
import org.spring.MemberRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Autowired
    private MemberRegisterService memberRegisterService;

    @Autowired
    private MemberDao  memberDao;


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

    @Bean
    public LoginController loginController(AuthService authService) {
        LoginController controller = new LoginController();
        controller.setAuthService(authService);
        return controller;
    }
    @Bean
    public LogoutController logoutController() {
        return new LogoutController();
    }

    @Autowired
    private ChangePasswordService changePasswordService;

    @Bean
    public ChangePwdController changePwdController(){
        ChangePwdController controller = new ChangePwdController();
        controller.setChangePasswordService(changePasswordService);
        return controller;
    }

    @Bean
    public MemberListController memberListController() {
        MemberListController controller = new MemberListController();
        controller.setMemberDao(memberDao);
        return controller;
    }

    @Bean
    public MemberDetailController memberDetailController() {
        MemberDetailController controller = new MemberDetailController();
        controller.setMemberDao(memberDao);
        return controller;
    }



}
