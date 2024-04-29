package com.example.spring_basic.mapper;

import com.example.spring_basic.domain.TodoVO;
import com.example.spring_basic.dto.PageRequestDTO;
import com.example.spring_basic.dto.TodoDTO;
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
public class TodoMapperTest {
    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    public void testGetTimer() {
        log.info(todoMapper.getTime());
    }

    @Test
    public void testInsert() {
        TodoVO todoVO = TodoVO.builder()
                .title("스프링 테스트")
                .dueDate(LocalDate.of(2022, 10, 10))
                .writer("user00")
                .build();
        todoMapper.insert(todoVO);
    }

    @Test
    public void testSelectAll() {
        List<TodoVO> todoVOList = todoMapper.selectAll();
        for (TodoVO todoVO : todoVOList) {
            log.info(todoVO);
        }
    }

    @Test
    public void testSelectOne() {
        Long tno = 2L;
        TodoVO todoVO = todoMapper.selectOne(tno);
        log.info(todoVO);
    }

    @Test
    public void testDelete() {
        Long tno = 2L;
        todoMapper.delete(tno);
    }

    @Test
    public void testUpdate() {
        Long tno = 4L;
        log.info(todoMapper.selectOne(tno));

        TodoVO todoVO = TodoVO.builder()
                .tno(tno)
                .title("updateTest")
                .dueDate(LocalDate.parse("2030-12-12"))
                .finished(true)
                .build();
        todoMapper.update(todoVO);
        log.info(todoMapper.selectOne(tno));
    }

    @Test
    public void testSelectList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(6).size(20).build();
        List<TodoVO> todoVOList = todoMapper.selectList(pageRequestDTO);
        for (TodoVO todoVO : todoVOList) {
            log.info(todoVO);
        }
    }

    @Test
    public void testGetCount() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
        log.info(todoMapper.getCount(pageRequestDTO) / 10);
    }

    @Test
    public void testSelectSearch() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .types(new String[]{"t", "w"})
                .keyword("스프링")
//                .finished(true)
                .from(LocalDate.of(2024, 04, 28))
                .to(LocalDate.parse("2024-04-30"))
                .build();
        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
        voList.forEach(vo -> log.info(vo));

        log.info(todoMapper.getCount(pageRequestDTO));
    }
}
