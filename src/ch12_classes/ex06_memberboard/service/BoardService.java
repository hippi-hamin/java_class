package ch12_classes.ex06_memberboard.service;

import ch12_classes.ex06_memberboard.dto.BoardDTO;
import ch12_classes.ex06_memberboard.repository.BoardRepository;

import java.util.Scanner;

public class BoardService {
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
        boolean result = BoardRepository.save(boardDTO);
        if (result) {
            System.out.println("글이 성공적으로 작성되었습니다.");
        } else {
            System.out.println("글 작성에 실패하였습니다.");
        }
    }
}
