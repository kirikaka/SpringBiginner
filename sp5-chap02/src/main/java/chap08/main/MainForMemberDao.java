package chap08.main;

import chap08.config.AppCtx;
import chap08.spring.Member;
import chap08.spring.MemberDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class MainForMemberDao {
    private static MemberDao memberDao;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        memberDao = ctx.getBean(MemberDao.class);

        selectAll();
        updateMember();
        insertMember();

        ctx.close();
    }
    private static DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MMddHHmmss");

    private static void insertMember() {
        System.out.println("Insert Member");
        String prefix=formatter.format(LocalDateTime.now());
        Member member=new Member(prefix+"@test.com",prefix,prefix,LocalDateTime.now());
        memberDao.insert(member);
        System.out.println(member.getId()+"데이터 추가.");
    }

    private static void updateMember() {
        System.out.println("updateMember");
        Member member=memberDao.selectByEmail("madvirus@madvirus.net");
        String oldPw=member.getPassword();
        String newPw= Double.toHexString(Math.random());
        member.changePassword(oldPw,newPw);
        memberDao.update(member);

        System.out.println("changePW "+ oldPw+">"+newPw);
    }

    private static void selectAll() {
        System.out.println("Select all");
        int total= memberDao.count();
        System.out.println("Total records: "+total);
        List<Member>members=memberDao.selectAll();
        for(Member member:members){
            System.out.println(member.getId()+" "+member.getEmail() +" "+member.getName());
        }
    }


}
