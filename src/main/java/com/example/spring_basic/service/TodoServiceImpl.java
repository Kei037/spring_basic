package com.example.spring_basic.service;

import com.example.spring_basic.domain.TodoVO;
import com.example.spring_basic.dto.TodoDTO;
import com.example.spring_basic.mapper.TodoMapper;
import com.sun.tools.javac.comp.Todo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO) {
        // 1) todoDTO를 전달받아 2) todoDTO를 todoVO로 변환 후 3) dao의 insert() 호출
        log.info(todoDTO);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info(todoVO);
        todoMapper.insert(todoVO);
    }

    @Override
    public List<TodoDTO> getAll() {
        List<TodoVO> voList = todoMapper.selectAll(); // dao에서 데이터베이스에서 들고온 VO리스트를 리턴
        List<TodoDTO> dtoList = new ArrayList<>();
        for (TodoVO todoVO: voList) {
            TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
            dtoList.add(todoDTO); // DTO 리스트에 저장
        }
        return dtoList;
    }
}
