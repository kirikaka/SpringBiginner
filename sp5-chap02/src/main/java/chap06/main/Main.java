package chap06.main;

import chap06.config.AppCtx;
import chap06.spring.Client;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppCtx.class);
        Client client = new Client();
        client.send();

        context.close();
    }
}
