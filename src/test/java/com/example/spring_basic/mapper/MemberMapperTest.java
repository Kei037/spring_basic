package com.example.spring_basic.mapper;

import com.example.spring_basic.domain.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class MemberMapperTest {

    @Autowired(required = false)
    private MemberMapper memberMapper;

    @Test
    public void testInsert() {
        MemberVO memberVo = MemberVO.builder()
                .memberId("admin")
                .memberPw("1234")
                .memberName("홍길동")
                .email("test@gmail.com")
                .phoneNumber("01012345678")
                .zipCode("12345")
                .address1("대구광역시 중구")
                .address2("푸르지오 203동 202호")
                .build();
        memberMapper.insert(memberVo);
    }
}