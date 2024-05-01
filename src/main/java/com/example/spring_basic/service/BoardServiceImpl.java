package com.example.spring_basic.service;

import com.example.spring_basic.domain.BoardVO;
import com.example.spring_basic.dto.BoardDTO;
import com.example.spring_basic.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(BoardDTO boardDTO) {
        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);
        boardMapper.insert(boardVO);
        log.info(boardVO);
    }

    @Override
    public List<BoardDTO> getAll() {
        List<BoardVO> voList = boardMapper.selectAll();
        List<BoardDTO> dtoList = new ArrayList<>();
        for (BoardVO boardVO: voList) {
            BoardDTO boardDTO = modelMapper.map(boardVO, BoardDTO.class);
            dtoList.add(boardDTO);
        }
        return dtoList;
    }

    @Override
    public BoardDTO getOne(Long no) {
        BoardVO boardVO = boardMapper.selectOne(no);
        return modelMapper.map(boardVO, BoardDTO.class);
    }

    @Override
    public void remove(Long no) {
        boardMapper.delete(no);
    }

    @Override
    public void modify(BoardDTO boardDTO) {
        log.info(boardDTO);
        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);
        log.info(boardDTO);
        boardMapper.update(boardVO);
    }
}
