package com.example.spring_basic.service;

import com.example.spring_basic.dto.PageRequestDTO;
import com.example.spring_basic.dto.PageResponseDTO;
import com.example.spring_basic.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    void register(TodoDTO todoDTO);

//    List<TodoDTO> getAll();

    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);

    TodoDTO getOne(Long tno);

    void remove(Long tno);

    void modify(TodoDTO todoDTO);

}
