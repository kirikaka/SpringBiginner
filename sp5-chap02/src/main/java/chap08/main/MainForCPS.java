package chap08.main;

import chap08.config.AppCtx;
import chap08.spring.ChangePasswordService;
import chap08.spring.MemberNotFoundException;
import chap08.spring.WrongIdPasswordException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForCPS {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        ChangePasswordService cps = ctx.getBean("changePwdSvc",ChangePasswordService.class);
        try{
            cps.changePassword("atg@atg.net","1111","1234");
            System.out.println("Password changed");
        } catch (MemberNotFoundException e){
            System.out.println("회원데이터 not found");
        } catch (WrongIdPasswordException e){
            System.out.println("Wrong id password");
        }
        ctx.close();
    }
}
