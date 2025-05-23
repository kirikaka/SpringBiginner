package chap04.spring;

import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;


public class MemberRegisterService {

    @Autowired
    private MemberDao memberDao= new MemberDao();

    public MemberRegisterService() {}

    public MemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void regist(RegisterRequest req){
        Member member = memberDao.selectByEmail(req.getEmail());
        if(member != null){
            throw new DuplicateMemberException("dup email "+req.getEmail());
        }
        Member newMember = new Member(
                req.getEmail(), req.getPassword(), req.getName(),
                LocalDateTime.now());
        memberDao.insert(newMember);

    }
}
