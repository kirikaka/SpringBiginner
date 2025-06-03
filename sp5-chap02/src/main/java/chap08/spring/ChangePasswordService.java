package chap08.spring;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ChangePasswordService {
    private MemberDao memberDao;
    public void changePassword(String email, String oldPwd,String newPwd){
        Member member=memberDao.selectByEmail(email);
        if (member==null){
            throw new MemberNotFoundException();
        }
        member.changePassword(oldPwd,newPwd);
        memberDao.update(member);
    }
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    //setMemberDao() 메서드로 의존하는 MemberDao를 전달받는다. 즉 세터
    //(setter)를 통해서 의존 객체를 주입받는다.
}
