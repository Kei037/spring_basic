package com.example.spring_basic.mapper;

import com.example.spring_basic.domain.TodoVO;

import java.util.List;

public interface TodoMapper {
    String getTime();

    void insert(TodoVO todoVO);

    List<TodoVO> selectAll();
}
