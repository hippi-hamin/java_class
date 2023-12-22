package ch12_classes.ex06_memberboard.service;

import ch12_classes.ex06_memberboard.dto.BoardDTO;
import ch12_classes.ex06_memberboard.repository.BoardRepository;

import java.util.List;
import java.util.Scanner;

public class BoardService {
    BoardRepository boardRepository = new BoardRepository();
    Scanner sc = new Scanner(System.in);
    public void save() {
        System.out.print("글의 제목 : ");
        String boardTitle = sc.nextLine();
        System.out.print("작성자 : ");
        String boardWriter = sc.nextLine();
        System.out.println("내용 : ");
        String boardContents = sc.nextLine();
        // boardDTO에 스캐너로 받은 정보를 넘겨주는 객체 선언
        BoardDTO boardDTO = new BoardDTO(boardTitle, boardWriter, boardContents);
        // boardRepository를 호출하면서 정보 넘겨준 후 result 받겠다.
        boolean result = boardRepository.save(boardDTO);
        if (result) {
            System.out.println("글이 성공적으로 작성되었습니다.");
        } else {
            System.out.println("글 작성에 실패하였습니다.");
        }
    }

    public void findAll() {
        List<BoardDTO> boardDTOList = boardRepository.findAll();
        System.out.println("id\t" + "title\t" + "writer\t" + "hits\t" + "date\t");
        for (BoardDTO boardDTO : boardDTOList) {
            System.out.println(boardDTO.getId() + "\t" + boardDTO.getBoardTitle() + "\t" + boardDTO.getBoardWriter()
            + "\t" + boardDTO.getBoardHits() + "\t" + boardDTO.getBoardCreatedAt());
        }
    }

    public void findById() {
        System.out.print("조회 글번호 : ");
        Long id = sc.nextLong();
        boolean result = boardRepository.updateHits(id);
        if (result) {
            BoardDTO boardDTO = boardRepository.findById(id);
            System.out.println("boardDTO = " + boardDTO);
        } else {
            System.out.println("요청하신 게시글은 존재하지 않습니다.");
        }
    }
}
