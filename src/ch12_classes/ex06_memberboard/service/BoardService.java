package ch12_classes.ex06_memberboard.service;

import ch12_classes.ex06_memberboard.common.CommonVariables;
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
        System.out.println("내용 : ");
        String boardContents = sc.nextLine();
        // boardDTO에 스캐너로 받은 정보를 넘겨주는 객체 선언
        BoardDTO boardDTO = new BoardDTO(boardTitle, CommonVariables.loginEmail, boardContents);
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

    public void update() {
        // 수정할 id를 입력받음
        // 해당 id 도서가 있다면 수정할 가격을 입력받고 수정 처리
        // 없으면 없다고 출력
        System.out.print("수정할 글 번호 : ");
        Long id = sc.nextLong();
        sc.nextLine();
        // 위에서 받은 id 값을 갖는 책이 있는 지 찾는 문장
        BoardDTO boardDTO = boardRepository.findById(id);
        if (boardDTO != null) {
            if (boardDTO.getBoardWriter().equals(CommonVariables.loginEmail)) {
                // 조회결과 있음
                System.out.println("해당 글번호의 글이 존재합니다.");
                System.out.print("수정할 제목 : ");
                String updateTitle = sc.nextLine();
                System.out.println("수정할 내용 : ");
                String updateContents = sc.nextLine();
                boolean updateResult = boardRepository.update(id, updateTitle, updateContents);
                if (updateResult) {
                    System.out.println("수정되었습니다.");
                } else {
                    System.out.println("수정 실패하였습니다.");
                }
            } else {
                System.out.println("글의 작성자가 아닙니다.");
            }
        }
    }
}

