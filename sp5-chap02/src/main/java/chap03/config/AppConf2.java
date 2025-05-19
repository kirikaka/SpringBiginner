package chap03.config;

import chap03.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConf2 {

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberPrinter memberPrinter;

    @Bean
    public MemberRegisterService memberRegSvc() {
        return new MemberRegisterService(memberDao);
    }

    @Bean
    public ChangePasswordService changePasswordSvc() {
        ChangePasswordService changePasswordSvc = new ChangePasswordService();
        changePasswordSvc.setMemberDao(memberDao);
        return changePasswordSvc;
    }




    @Bean
    public MemberListPrinter listPrinter() {
        return new MemberListPrinter(memberDao,memberPrinter);
    }

    @Bean
    public MemberInfoPrinter infoPrinter() {
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
//        infoPrinter.setMemberDao(memberDao);
//        infoPrinter.setPrinter(memberPrinter);
        return infoPrinter;
    }
}






























