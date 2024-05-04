package com.example.spring_basic.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberVO {
    private Integer no;
    private String memberId;
    private String passwd;
    private String name;
    private String email;
    private String phone;
    private String zipcode;
    private String address1;
    private String address2;
    private LocalDateTime addDate;
}
