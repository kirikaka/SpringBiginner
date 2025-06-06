package chap04.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class MemberPrinter {
    @Autowired(required = false)
    private DateTimeFormatter dateTimeFormatter;
//    public void print(Member member) {
//        System.out.printf(
//                "회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
//                member.getId(), member.getEmail(),
//                member.getName(), member.getRegisterDateTime());
//    }

    public void print(Member member) {
        if(dateTimeFormatter == null){
            System.out.printf("회원 정보 : 아이디 =%d , 이메일 =%s, 이름=%s,등록일 =%tF\n",
                    member.getId(),member.getEmail(),member.getName(),member.getRegisterDateTime());
        } else {
            System.out.printf("회원 정보 : 아이디 =%d , 이메일 =%s, 이름=%s,등록일 =%tF\n",
                    member.getId(),member.getEmail(),member.getName(),dateTimeFormatter.format(member.getRegisterDateTime()));
        }
    }

    @Autowired(required = false)
    public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }
//    @Autowired(required = false)
//    public void setDateTimeFormatter(Optional<DateTimeFormatter> fomatterOpt) {
//        if(fomatterOpt.isPresent()){
//            this.dateTimeFormatter = fomatterOpt.get();
//        } else {
//            this.dateTimeFormatter = null;
//        }
//    }
}
