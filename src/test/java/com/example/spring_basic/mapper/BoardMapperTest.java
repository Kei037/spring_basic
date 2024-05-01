package com.example.spring_basic.mapper;

import com.example.spring_basic.domain.BoardVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class BoardMapperTest {
    @Autowired(required = false)
    private BoardMapper boardMapper;

    @Test
    public void testInsert() {
        BoardVO boardVO = BoardVO.builder()
                .title("게시판 테스트")
                .content("이것은 본문입니다.")
                .writer("user00")
                .passwd("1234")
                .build();
        boardMapper.insert(boardVO);
    }

    @Test
    public void testSelectAll() {
        List<BoardVO> boardVOList = boardMapper.selectAll();
        for (BoardVO boardVO : boardVOList) {
            log.info(boardVO);
        }
    }

    @Test
    public void testSelectOne() {
        Long no = 1L;
        BoardVO boardVO = boardMapper.selectOne(no);
        log.info(boardVO);
    }

    @Test
    public void testDelete() {
        Long no = 2L;
        boardMapper.delete(no);
    }

    @Test
    public void testUpdate() {
        Long no = 4L;
        BoardVO boardVO = BoardVO.builder()
                .no(no)
                .title("수정제목")
                .content("수정된 본문입니다.")
                .passwd("1234")
                .build();
        boardMapper.update(boardVO);
        log.info(boardMapper.selectOne(no));
    }
}
