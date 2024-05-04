package com.example.spring_basic.service;

import com.example.spring_basic.domain.BoardVO;
import com.example.spring_basic.domain.MemberVO;
import com.example.spring_basic.dto.BoardDTO;
import com.example.spring_basic.dto.MemberDTO;
import com.example.spring_basic.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberMapper memberMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(MemberDTO memberDTO) {
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        log.info(memberVO);
        memberMapper.insert(memberVO);
    }

    @Override
    public boolean isMember(MemberDTO memberDTO) {
        log.info(memberDTO);
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        log.info(memberVO);
        return memberMapper.selectOne(memberVO) != null;
    }

    @Override
    public MemberDTO getMember(String memberId) {
        return modelMapper.map(memberMapper.select(memberId), MemberDTO.class);
    }

    @Override
    public void modify(MemberDTO memberDTO) {
        memberMapper.update(modelMapper.map(memberDTO, MemberVO.class));
    }
}
