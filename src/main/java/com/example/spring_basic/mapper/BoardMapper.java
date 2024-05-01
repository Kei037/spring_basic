package com.example.spring_basic.mapper;

import com.example.spring_basic.domain.BoardVO;

import java.util.List;

public interface BoardMapper {
    void insert(BoardVO boardVO);

    List<BoardVO> selectAll();

    BoardVO selectOne(Long no);

    void update(BoardVO boardVO);

    void delete(Long no);
}
