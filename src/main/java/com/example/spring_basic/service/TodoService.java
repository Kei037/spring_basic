package com.example.spring_basic.service;

import com.example.spring_basic.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    void register(TodoDTO todoDTO);
    List<TodoDTO> getAll();
}
