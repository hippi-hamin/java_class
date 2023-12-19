package ch12_classes.ex04;

import ch10_class.ex11.Board;
import ch12_classes.ex02.BookDTO;
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
        String boardWriter = sc.nextLine();
        System.out.println("내용 : ");
        String boardContents = sc.nextLine();
        System.out.print("비밀번호 : ");
        String boardPass = sc.nextLine();
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

    public void findById() {
        System.out.print("조회 글번호 : ");
        Long id = sc.nextLong();sc.nextLine();
        BoardDTO boardDTO = boardRepository.findById(id);
        if (boardDTO != null) {
            System.out.println("조회하신 글의 정보입니다 : " + boardDTO);
            System.out.println("내용 : " + boardDTO.getBoardContents());
        } else {
            System.out.println("조회결과가 없습니다.");
        }
    }

    public void update() {
        boolean run = true;
        // 수정할 id를 입력받음
        // 해당 id 도서가 있다면 수정할 가격을 입력받고 수정 처리
        // 없으면 없다고 출력
        System.out.print("수정할 글 번호 : ");
        Long id = sc.nextLong();
        sc.nextLine();
        // 위에서 받은 id 값을 갖는 책이 있는 지 찾는 문장
        BoardDTO boardDTO = boardRepository.findById(id);
        if (boardDTO != null) {
            //조회결과 있음
            System.out.println("해당 글번호의 글이 존재합니다.");
            while (run) {
                System.out.print("비밀번호를 입력하세요 : ");
                String boardPass = sc.nextLine();
                if (boardPass.equals(boardDTO.getBoardPass())) {
                    System.out.print("수정할 제목 : ");
                    String updateTitle = sc.nextLine();
                    System.out.println("수정할 내용 : ");
                    String updateContents = sc.nextLine();
                    boolean updateResult = boardRepository.update(id, updateTitle, updateContents);
                    if (updateResult) {
                        System.out.println("수정되었습니다.");
                        run = false;
                    } else {
                        System.out.println("수정 실패하였습니다.");
                    }
                } else {
                    System.out.println("비밀번호가 틀렸습니다.");
                }
            }
        }
    }

    public void delete() {
        boolean run = true;
        System.out.println("삭제할 글번호 : ");
        Long id = sc.nextLong();sc.nextLine();
        BoardDTO boardDTO = boardRepository.findById(id);
        while (run) {
            System.out.print("삭제를 희망하시면 비밀번호를 입력하세요 : ");
            String boardPass = sc.nextLine();
            if (boardPass.equals(boardDTO.getBoardPass())) {
                boolean result = boardRepository.delete(id);
                if (result) {
                    System.out.println("삭제 성공");
                    run = false;
                } else {
                    System.out.println("삭제 실패");
                }
            } else {
                System.out.println("비밀번호가 틀렸습니다.");
            }
        }
    }

    public void search() {
        System.out.print("검색할 제목 : ");
        String boardTitle = sc.nextLine();
        // 검색 결과가 여러 개 일 수 있기 때문에 List 메서드를 사용해 줌.
        List<BoardDTO> boardDTOList = boardRepository.search(boardTitle);
        if (boardDTOList.size() > 0) {
            for (BoardDTO boardDTO : boardDTOList) {
                System.out.println("boardDTO = " + boardDTO);
            }
        } else {
            // boardDTOList.size() == 0 => 결과가 없다
            System.out.println("검색 결과가 없습니다!");
        }
    }
}
