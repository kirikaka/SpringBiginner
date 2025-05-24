package chap05.config;


import chap05.spring.MemberPrinter;
import chap05.spring.MemberSummaryPrinter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"chap05.spring","chap05.spring2"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,pattern = "spring\\..*Dao"))
//@ComponentScan(basePackages = {"chap05.spring"},
//        excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ,pattern = "spring.*Dao"))
public class AppCtxWithExclude {

    @Bean
    @Qualifier("printer")
    public MemberPrinter memberPrinter1(){
        return new MemberPrinter();
    }
    @Bean
    @Qualifier("summaryPrinter")
    public MemberSummaryPrinter memberPrinter2(){
        return new MemberSummaryPrinter();
    }


}
