package com.example.spring_basic.service;


import com.example.spring_basic.dto.MemberDTO;

import java.util.List;

public interface MemberService {
    void register(MemberDTO memberDTO);

    boolean isMember(MemberDTO memberDTO);

    MemberDTO getMember(String memberId);

    void modify(MemberDTO memberDTO);
}
