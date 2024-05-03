package com.example.spring_basic.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private Integer mno;
    private String memberId;
    private String memberPw;
    private String memberName;
    private String email;
    private String phoneNumber;
    private String phone1;
    private String phone2;
    private String phone3;
    private String zipCode;
    private String address1;
    private String address2;
    private LocalDate addDate;
}


