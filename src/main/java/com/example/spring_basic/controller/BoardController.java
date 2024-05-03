package com.example.spring_basic.controller;

import com.example.spring_basic.dto.BoardDTO;
import com.example.spring_basic.service.BoardService;
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
import java.util.List;

@Controller
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/add")
    public void add() {
        log.info("...addPage()");
    }

    @PostMapping("/add")
    public String addPost(@Valid BoardDTO boardDTO, RedirectAttributes redirectAttributes) {
        boardService.register(boardDTO);
        log.info(boardDTO);

        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public void list(Model model) {
        List<BoardDTO> dtoList = boardService.getAll();
        model.addAttribute("dtoList", dtoList);
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long no, Model model) {
        BoardDTO boardDTO = boardService.getOne(no);
        log.info(boardDTO);
        model.addAttribute("dto", boardDTO);
    }

    @PostMapping("/modify")
    public String modify(@Valid BoardDTO boardDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            log.info(("has error..."));
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("no", boardDTO.getNo());
            return "redirect:/board/modify";
        }

        boardService.modify(boardDTO);
        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(Long no) {
        log.info("---------remove---------");
        log.info("no: " + no);

        boardService.remove(no);

        return "redirect:/board/list";
    }
}
