package com.bit.springboard.service;

import com.bit.springboard.dto.BoardDto;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.time.LocalDateTime;

public class NoticeServiceRun {
    public static void main(String[] args) {
        AbstractApplicationContext factory =
                new GenericXmlApplicationContext("root-context.xml");

        BoardService boardService = factory.getBean("noticeServiceImpl", BoardService.class);

        // post 알림판 올리기
        BoardDto boardDto = new BoardDto();
        boardDto.setTitle("알림판1");
        boardDto.setContent("알림판 1번에 올립니다.");
        // writer_id는 member 테이블의 id 컬럼을 foreign key로 가져오기 때문에
        // member 테이블에 존재하는 id 값만 입력할 수 있다.
        boardDto.setWRITER_ID(4);

        boardService.post(boardDto);

        // modify 알림판 수정
        BoardDto modifyBoardDto = new BoardDto();

        modifyBoardDto.setId(1);
        modifyBoardDto.setTitle("알림판1-수정");
        modifyBoardDto.setContent("수정사항-알림판1번에올림.");
        modifyBoardDto.setModdate(LocalDateTime.now());

        boardService.modify(modifyBoardDto);

        // getboardList 게시글 목록 조회
        boardService.getBoardList().forEach(board -> {
            System.out.println(board);
        });

        // 알림판 삭제
        boardService.delete(2);

        // 특정 id로 하나 조회
        System.out.println(boardService.getBoard(5));

        factory.close();
    }
}
