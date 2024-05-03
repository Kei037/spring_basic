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
                .memberId("admin")
                .memberPw("1234")
                .memberName("홍길동")
                .email("test@gmail.com")
                .zipCode("12345")
                .address1("대구광역시 중구")
                .address2("푸르지오 203동 202호")
                .build();
        memberDTO.setPhone("010-1234-5678");
        memberService.register(memberDTO);
    }
}