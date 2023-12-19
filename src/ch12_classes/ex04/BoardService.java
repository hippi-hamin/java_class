package ch12_classes.ex04;

import ch10_class.ex11.Board;
import ch12_classes.ex03.MemberDTO;

import java.util.List;
import java.util.Scanner;

public class BoardService {
    Scanner sc = new Scanner(System.in);
    BoardRepository boardRepository = new BoardRepository();

    public void write() {
        System.out.print("글의 제목 : ");
        String boardTitle = sc.nextLine();
        System.out.print("작성자 : ");
        String boardWriter = sc.next();
        System.out.print("내용 : ");
        String boardContents = sc.nextLine();
        System.out.println("비밀번호 : ");
        String boardPass = sc.next();
        // boardDTO에 스캐너로 받은 정보를 넘겨주는 생성자 선언
        BoardDTO boardDTO = new BoardDTO(boardTitle, boardWriter, boardContents, boardPass);
        // boardRepository를 호출하면서 정보 넘겨준 후 result 받겠다.
        boolean result = BoardRepository.write(boardDTO);

        if (result) {
            System.out.println("글이 성공적으로 작성되었습니다.");
        } else {
            System.out.println("글 작성에 실패하였습니다.");
        }
    }

    public void list() {
        List<BoardDTO> boardDTOList = boardRepository.list();
        for (BoardDTO boardDTO : boardDTOList) {
            System.out.println(boardDTO);
        }
    }
}
