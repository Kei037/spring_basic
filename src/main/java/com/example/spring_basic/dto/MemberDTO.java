package com.example.spring_basic.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private Integer no;
    private String memberId;
    private String passwd;
    private String name;
    private String email;
    private String phone1;
    private String phone2;
    private String phone3;
    private String zipcode;
    private String address1;
    private String address2;
    private LocalDateTime addDate;

    public void setPhone(String phone) {
        String[] arr = phone.split("-");
        this.phone1 = arr[0];
        this.phone2 = arr[1];
        this.phone3 = arr[2];
    }
    public String getPhone() {
        return phone1 + "-" + phone2 + "-" + phone3;
    }
}


