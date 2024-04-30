package com.example.spring_basic.controller;

import com.example.spring_basic.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    @GetMapping("/login")
    public void login() {
        log.info("...login()");
    }

    @PostMapping("/login")
    public String loginPost(LoginDTO loginDTO, RedirectAttributes redirectAttributes) {
        log.info("...loginPost()");
        log.info(loginDTO);
        if (loginDTO.getMemberId().equals("admin") && loginDTO.getMemberPass().equals("1111")) {
            log.info("로그인 성공");
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            return "redirect:/member/success";
        }
        log.info("로그인 실패");
        return "redirect:/member/fail";
    }

    @GetMapping("/success")
    public void success() {
        log.info("...success()");
    }

    @GetMapping("/fail")
    public void fail() {
        log.info("...fail()");
    }
}
