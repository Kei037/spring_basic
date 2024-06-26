package com.example.spring_basic.service;

import com.example.spring_basic.domain.TodoVO;
import com.example.spring_basic.dto.PageRequestDTO;
import com.example.spring_basic.dto.PageResponseDTO;
import com.example.spring_basic.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class TodoServiceImplTest {
    @Autowired
    private TodoService todoService;

    @Test
    void testRegister() {
        TodoDTO todoDTO = TodoDTO.builder()
                .title("Test...")
                .dueDate(LocalDate.now())
                .writer("user1")
                .build();
        todoService.register(todoDTO);
    }

//    @Test
//    public void testGetAll() {
//        List<TodoDTO> dtoList = todoService.getAll();
//        for (TodoDTO todoDTO : dtoList) {
//            log.info(todoDTO);
//        }
////        dtoList.forEach(todoDTO -> log.info(todoDTO));
//    }

    @Test
    public void pageingTest() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
        PageResponseDTO<TodoDTO> pageResponseDTO = todoService.getList(pageRequestDTO);
        log.info(pageResponseDTO);
        for (TodoDTO todoDTO : pageResponseDTO.getDtoList()) {
            log.info(todoDTO);
        }
    }

    @Test
    public void testModify() {
        Long tno = 4L;
        TodoDTO todoDTO = TodoDTO.builder()
                .tno(tno)
                .title("updateTest2")
                .dueDate(LocalDate.parse("2030-01-24"))
                .finished(true)
                .build();
        todoService.modify(todoDTO);
        log.info(todoService.getOne(tno));
    }
}