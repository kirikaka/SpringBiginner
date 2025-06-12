package org.controller;

import org.spring.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class RestMemberController {
    private MemberDao memberDao;
    private MemberRegisterService registerService;

    @GetMapping("/api/members")
    public List<Member> members(){
        return memberDao.selectAll();
    }

    @PostMapping("/api/members")
    public ResponseEntity<Object> newMember(
            @RequestBody @Valid RegisterRequest regReq,
            HttpServletResponse response) throws IOException {
        try{
            Long newMemberId=registerService.regist(regReq);
            response.setHeader("Location", "/api/members/"+newMemberId);
            response.setStatus(HttpServletResponse.SC_CREATED);
            URI uri=new URI("/api/members/"+newMemberId);
            return ResponseEntity.created(uri).build();

        } catch(DuplicateMemberException | URISyntaxException dupEx){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }


    @GetMapping("/api/members/{id}")
    public Member getMember(@PathVariable Long id,
                            HttpServletResponse response) throws IOException {
        Member member = memberDao.selectById(id);
        if(member == null){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        return member;
    }

    @GetMapping("/api/members/{id}")
    public ResponseEntity<Object> member(@PathVariable Long id){
        Member member = memberDao.selectById(id);
        if(member == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("no member"));

        }
        return ResponseEntity.status(HttpStatus.OK).body(member);
    }




    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    public void setMemberRegisterService(MemberRegisterService registerService) {
        this.registerService = registerService;
    }



}
