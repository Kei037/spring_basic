package com.example.spring_basic.controller;

import com.example.spring_basic.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {
    @RequestMapping("/list")
    public void list() {
        log.info("todo list...");
    }

//    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/register")
    public void register() {
        log.info("todo register...");
    }
    @PostMapping("/register")
    public void registerPOST(TodoDTO todoDtd) {
        log.info(("POST todo register..."));
        log.info(todoDtd);
    }
}
