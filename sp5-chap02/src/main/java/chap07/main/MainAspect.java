package chap07.main;

import chap07.config.AppCtx;
import chap07.spring.Calculator;
import chap07.spring.RecCalculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspect {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        RecCalculator cal=ctx.getBean("calculator",RecCalculator.class);
        long fiveFact=cal.factorial(5);

        System.out.println("cal.factorial(5) = "+fiveFact);
        System.out.println(cal.getClass().getName());
        ctx.close();
    }
}
