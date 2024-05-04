package com.example.spring_basic.service;

import com.example.spring_basic.domain.MemberVO;
import com.example.spring_basic.dto.BoardDTO;
import com.example.spring_basic.dto.MemberDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class MemberServiceImplTest {
    @Autowired
    private MemberService memberService;

    @Test
    void testRegister() {
        MemberDTO memberDTO = MemberDTO.builder()
                .memberId("test4")
                .passwd("1111")
                .name("이름")
                .email("test@gmail.com")
                .zipcode("12345")
                .address1("대구광역시 중구")
                .address2("푸르지오 203동 202호")
                .build();
        memberDTO.setPhone("010-1234-5678");
        memberService.register(memberDTO);
    }

    @Test
    public void testIsMember() {
        MemberDTO memberDTO = MemberDTO.builder()
                .memberId("test")
                .passwd("1112")
                .build();
        log.info(memberService.isMember(memberDTO));
    }

    @Test
    public void getMember() {
        log.info(memberService.getMember("test"));
    }

    @Test
    public void modify() {
        String memberId = "test";
        MemberDTO memberDTO = MemberDTO.builder()
                .memberId(memberId)
                .name("테스트")
                .email("abcc@def.com")
                .phone1("111")
                .phone2("2222")
                .phone3("3333")
                .zipcode("54321")
                .address1("주소1")
                .address2("주소2").build();
        memberService.modify(memberDTO);
        log.info(memberService.getMember(memberId));
    }
}