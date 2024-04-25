package com.example.spring_basic.controller;

import com.example.spring_basic.dto.TodoDTO;
import com.example.spring_basic.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @RequestMapping("/list")
    public void list(Model model) {
        log.info("todo list...");
        model.addAttribute("dtoList", todoService.getAll());
    }

//    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/register")
    public void register() {
        log.info("todo register...");
    }

    @PostMapping("/register")
    public String registerPOST(@Valid TodoDTO todoDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info(("POST todo register..."));

        if (bindingResult.hasErrors()) {
            log.info("hass error...");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }

        log.info(todoDto);

        todoService.register(todoDto);
        return "redirect:/todo/list";
    }


}
