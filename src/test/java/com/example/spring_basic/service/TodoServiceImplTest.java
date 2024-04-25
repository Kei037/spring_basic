package com.example.spring_basic.service;

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

    @Test
    public void testGetAll() {
        List<TodoDTO> dtoList = todoService.getAll();
        for (TodoDTO todoDTO : dtoList) {
            log.info(todoDTO);
        }
//        dtoList.forEach(todoDTO -> log.info(todoDTO));
    }
}