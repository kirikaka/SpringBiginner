package org.controller;

import org.spring.DuplicateMemberException;
import org.spring.MemberRegisterService;
import org.spring.RegisterRequest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistController {

    private MemberRegisterService memberRegisterService;
    public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
        this.memberRegisterService = memberRegisterService;
    }


    @RequestMapping("/register/step1")
    public String handleStep1(){
        return "register/step1";
    }

//    @PostMapping("/register/step2")
//    public String handleStep2(HttpServletRequest request){
//        String agreeParam = request.getParameter("agree");
//        if(agreeParam == null || !agreeParam.equals("true")){
//            return "register/step1";
//
//        }
//        return "register/step2";
//    }
    @PostMapping("/register/step2")
    public String handleStep2(@RequestParam(value = "agree",defaultValue = "false") Boolean agree, Model model){
        if(!agree){
            return "register/step1";
        }
        model.addAttribute("registerRequest", new RegisterRequest());
        return "register/step2";
    }

    @GetMapping("/register/step2")
    public String handleStep2Get(){
        return "redirect:/register/step1";
    }


    @PostMapping("/register/step3")
    public String handleStep3(@ModelAttribute("formData") RegisterRequest regReq){
        try {
            memberRegisterService.regist(regReq);
            return "register/step3";
        } catch (DuplicateMemberException e) {
            return "register/step2";
        }
    }


}
