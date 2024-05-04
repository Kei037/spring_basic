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
        MemberVO memberVO = MemberVO.builder()
                .memberId("test")
                .passwd("1111")
                .name("이름")
                .email("test@abc.com")
                .phone("111-2222-3333")
                .zipcode("12345")
                .address1("주소1")
                .address2("주소2").build();
        memberMapper.insert(memberVO);
    }

    @Test
    void selectOne() {
        MemberVO memberVO = MemberVO.builder()
                .memberId("test")
                .passwd("1111").build();
        log.info(memberMapper.selectOne(memberVO));
    }

    @Test
    void select() {
        log.info(memberMapper.select("test"));
    }

    @Test
    void update() {
        String memberId = "test";
        MemberVO memberVo = MemberVO.builder()
                .memberId(memberId)
                .name("테스트")
                .email("abcc@def.com")
                .phone("012-3456-7890")
                .zipcode("54321")
                .address1("주소1")
                .address2("주소2").build();
        memberMapper.update(memberVo);
        log.info(memberMapper.select(memberId));
    }
}