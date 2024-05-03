package com.example.spring_basic.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardVO {
    private Integer no;
    private String title;
    private String content;
    private String writer;
    private String passwd;
    private LocalDate addDate;
    private Integer hit;
}
