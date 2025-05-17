package chap03;

import com.sun.jdi.request.DuplicateRequestException;

import java.time.LocalDateTime;

public class MemberRegisterService {
    private MemberDao memberDao= new MemberDao();

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
