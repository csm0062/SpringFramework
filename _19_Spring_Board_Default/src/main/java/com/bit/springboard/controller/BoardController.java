package com.bit.springboard.controller;

import com.bit.springboard.dto.BoardDto;
import com.bit.springboard.dto.MemberDto;
import com.bit.springboard.service.BoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    private BoardService boardService;
    private ApplicationContext applicationContext;

    @Autowired
    public BoardController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @GetMapping("/free-list.do")
    public String freeListView() {
        return "board/free-list";
    }

    @GetMapping("/free-detail.do")
    public String freeDetailView() {
        return "board/free-detail";
    }

    @GetMapping("/notice-list.do")
    public String noticeListView() {
        return "board/notice-list";
    }

    @GetMapping("/notice-detail.do")
    public String noticeDetailView() {
        return "board/notice-detail";
    }

    @GetMapping("/post.do")
    public String postView(HttpSession session) {
        MemberDto loginMember =(MemberDto) session.getAttribute("loginMember");

        if(loginMember == null) {
            return "redirect:/member/login.do";
        }
        return "board/post";
    }


    @PostMapping("/post.do")
    public String post(BoardDto boardDto) {
        if(boardDto.getType().equals("free")) {
            boardService = applicationContext.getBean("freeBoardServiceImpl", BoardService.class);
        } else {
            boardService = applicationContext.getBean("noticeServiceImpl", BoardService.class);
        }
        boardService.post(boardDto);

        if(boardDto.getType().equals("free")) {
            return "board/free-list";
        } else {
            return "board/notice-list";
        }
    }

}
