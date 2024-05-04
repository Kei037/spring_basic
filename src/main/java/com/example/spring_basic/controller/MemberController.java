package com.example.spring_basic.controller;

import com.example.spring_basic.dto.LoginDTO;
import com.example.spring_basic.dto.MemberDTO;
import com.example.spring_basic.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/register")
    public void register() {
        log.info("...register()");
    }

    @PostMapping("/register")
    public String registerPost(MemberDTO memberDTO) {
        log.info("...registerPost()");
        log.info(memberDTO);

        memberService.register(memberDTO);
        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public void login() {
        log.info("...login()");
    }

    @PostMapping("/login")
    public String loginPost(LoginDTO loginDTO, HttpServletRequest request) {
        log.info("...loginPost()");
        log.info(loginDTO);

        MemberDTO memberDTO = MemberDTO.builder()
                .memberId(loginDTO.getMemberId())
                .passwd(loginDTO.getMemberPass())
                .build();
        if (memberService.isMember(memberDTO)) {
            HttpSession session = request.getSession();
            session.setAttribute("memberId", loginDTO.getMemberId());
            return "redirect:/member/modify";
        } else {
            return "redirect:/member/login";
        }
    }

    @GetMapping("/success")
    public void success() {
        log.info("...success()");
    }

    @GetMapping("/fail")
    public void fail() {
        log.info("...fail()");
    }

    @GetMapping("/modify")
    public void modify(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String memberId = (String) session.getAttribute("memberId");
        log.info("...modify()");
        model.addAttribute("dto", memberService.getMember(memberId));
    }

    @PostMapping("/modify")
    public void modifyPost(MemberDTO memberDTO, HttpServletRequest request) {
        log.info("...modifyPost()");
        HttpSession session = request.getSession();
        String memberId = (String) session.getAttribute("memberId");

        memberDTO.setMemberId(memberId);
        memberService.modify(memberDTO);
    }
}
