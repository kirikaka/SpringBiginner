package chap04.spring;


public class MemberSummaryPrinter extends MemberPrinter {

    @Override
    public void print(Member member) {
        System.out.printf("회원 정보 : dlapdlf =%s, 이름=%s\n",member.getEmail(),member.getName());
    }
}
