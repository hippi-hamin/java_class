package ch12_classes.ex06_memberboard.service;

import ch10_class.ex11.Board;
import ch12_classes.ex06_memberboard.common.CommonVariables;
import ch12_classes.ex06_memberboard.dto.BoardDTO;
import ch12_classes.ex06_memberboard.dto.CommentDTO;
import ch12_classes.ex06_memberboard.repository.BoardRepository;
import ch12_classes.ex06_memberboard.repository.CommentRepository;

import java.util.List;
import java.util.Scanner;

public class BoardService {
    BoardRepository boardRepository = new BoardRepository();
    CommentRepository commentRepository = new CommentRepository();
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
            System.out.println("====== 댓글 =======");
            List<CommentDTO> commentDTOs = commentRepository.commentList(id);
            if (commentDTOs.size() > 0) { // commentDTOs를 != null 이라는 형식으로 쓸 경우 오류가 자주 발생해서
                                          // commentDTOs.size() > 0 라는 형식을 많이 씀.
            // 댓글 전체를 표시해야 하기 때문에 for 문을 사용해줌
                for(CommentDTO commentDTO : commentDTOs){
                    System.out.println(commentDTO);
                }
            } else {
                System.out.println("작성된 댓글이 없습니다.");
            }
            System.out.println("댓글을 작성하시려면 1번을 입력해주세요.");
            System.out.println("메인메뉴로 돌아가시려면 2번을 입력해주세요.");
            int selectNo = sc.nextInt();sc.nextLine();
            if (selectNo == 1) {
                System.out.print("댓글 : ");
                String commentContents = sc.nextLine();
                CommentDTO commentDTO = new CommentDTO(id, CommonVariables.loginEmail, commentContents);
                boolean result1 = commentRepository.comment(commentDTO);
                if (result1) {
                    System.out.println("댓글이 성공적으로 작성되었습니다.");
                } else {
                    System.out.println("댓글이 작성되지 않았습니다.");
                }
            } else if (selectNo == 2) {
                System.out.println("메인메뉴로 돌아갑니다.");
            }
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
                // 글의 작성자가 아닌 이상 (작성자가 아닌 다른 이메일로 로그인이 되어있는 경우) 수정불가
                System.out.println("글의 작성자가 아닙니다.");
            }
        }
    }

    public void delete() {
        // 수정할 id를 입력받음
        // 해당 id 도서가 있다면 수정할 가격을 입력받고 수정 처리
        // 없으면 없다고 출력
        System.out.print("삭제할 글 번호 : ");
        Long id = sc.nextLong();
        sc.nextLine();
        // 위에서 받은 id 값을 갖는 책이 있는 지 찾는 문장
        BoardDTO boardDTO = boardRepository.findById(id);
        if (boardDTO != null) {
            if (boardDTO.getBoardWriter().equals(CommonVariables.loginEmail)) {
                System.out.println("해당 글번호의 글이 존재합니다.");
                boolean deleteResult = boardRepository.delete(id);
                if (deleteResult) {
                    System.out.println("삭제되었습니다.");
                } else {
                    System.out.println("삭제하지 못했습니다.");
                }
            } else {
                System.out.println("글의 작성자가 아닙니다.");
            }
        }
    }

    public void search() {

        System.out.print("검색할 제목 : ");
        String boardTitle = sc.nextLine();
        // 검색 결과가 여러 개 일 수 있기 때문에 List 메서드를 사용해 줌.
        List<BoardDTO> searchList = boardRepository.search(boardTitle);
        if (searchList.size() > 0) {
            System.out.println("검색 결과");
            listPrint(searchList);
        } else {
            // boardDTOList.size() == 0 => 결과가 없다
            System.out.println("검색 결과가 없습니다!");
        }
    }

    private void listPrint(List<BoardDTO> boardDTOList) {
        System.out.println("id\t" + "title\t" + "writer\t" + "hits\t" + "date\t");
        for (BoardDTO boardDTO : boardDTOList) {
            System.out.println(boardDTO.getId() + "\t" + boardDTO.getBoardTitle() + "\t" +
                    boardDTO.getBoardWriter() + "\t" + boardDTO.getBoardHits() + "\t" +
                    boardDTO.getBoardCreatedAt() + "\t");
        }
    }

    public void testData() {
        for (int i = 0; i < 11; i++) {
            BoardDTO boardDTO = new BoardDTO("title" + i, "writer" + i, "contents" + i);
            boardRepository.save(boardDTO);
        }
    }
}


