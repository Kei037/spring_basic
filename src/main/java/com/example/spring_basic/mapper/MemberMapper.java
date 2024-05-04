package com.example.spring_basic.mapper;

import com.example.spring_basic.domain.MemberVO;

public interface MemberMapper {
    void insert(MemberVO memberVO);

    MemberVO selectOne(MemberVO memberVO);

    MemberVO select(String memberID);

    void update(MemberVO memberVO);
}
