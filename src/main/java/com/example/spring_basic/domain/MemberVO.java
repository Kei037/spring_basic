package com.example.spring_basic.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberVO {
    private Long mno;
    private String memberId;
    private String memberPw;
    private String memberName;
    private String email;
    private String phoneNumber;
    private String zipCode;
    private String address1;
    private String address2;
    private LocalDate addDate;
}
