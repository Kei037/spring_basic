package com.example.spring_basic.service;

import com.example.spring_basic.dto.BoardDTO;
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
class BoardServiceImplTest {
    @Autowired
    private BoardService boardService;

    @Test
    void testRegister() {
        BoardDTO boardDTO = BoardDTO.builder()
                .title("게시판 테스트2")
                .content("본문임!")
                .writer("작성자1")
                .passwd("1234")
                .build();
        boardService.register(boardDTO);
    }

    @Test
    public void testGetAll() {
        List<BoardDTO> dtoList = boardService.getAll();
        for (BoardDTO boardDTO : dtoList) {
            log.info(boardDTO);
        }
    }

    @Test
    public void testGetOne() {
        Long no = 1L;
        BoardDTO boardDTO = boardService.getOne(no);
        log.info(boardDTO);
    }

    @Test
    public void testRemove() {
        Long no = 3L;
        boardService.remove(no);
    }
}