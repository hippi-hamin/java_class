package ch12_classes.ex04;

import ch12_classes.ex02.BookDTO;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {

    private static List<BoardDTO> boardDTOList = new ArrayList<>();
    /**
     * 글작성 메서드
     * name : write
     * @param boardDTO
     * @return : boolean
     * 실행내용
     * Service로 부터 전달 받은 DTO 객체를 리스트에 저장하고 결과를 리턴
     */
    public static boolean write(BoardDTO boardDTO) {
        return boardDTOList.add(boardDTO);
    }

    public List<BoardDTO> list() {
        return boardDTOList;
    }

    public BoardDTO findById(Long id) {
        BoardDTO boardDTO = null;
        for (BoardDTO boardDTO1 : boardDTOList) {
            if (id.equals(boardDTO1.getId())){
                boardDTO1.setBoardHits();
                boardDTO = boardDTO1;
            }
        }
        return boardDTO;
    }

    public boolean update(Long id, String updateTitle, String updateContents) {
        boolean result = false;
        for (int i = 0; i < boardDTOList.size(); i++) {
            // memberDTOList.get(i) 인덱스에서 LoginEmail과 같은 memberEmail 정보를 찾는 문장
            if (id.equals(boardDTOList.get(i).getId())) {
                // memberDTOList.get(i) = 해당 인덱스에 접근 하여
                // setBoardTitle(updateTitle) = 해당 데이터에 board 값을 수정.
                boardDTOList.get(i).setBoardTitle(updateTitle);
                // setBoardContents(updateContents) = 해당 데이터에 board 값을 수정.
                boardDTOList.get(i).setBoardContents(updateContents);
                result = true;
            }
        }
        return result;
    }

    public boolean delete(Long id) {
        boolean result = false;
        for (int i = 0; i < boardDTOList.size(); i++) {
            if (id.equals(boardDTOList.get(i).getId())) {
                boardDTOList.remove(i);
                return true;
            }
        }
        return result;
    }

    public List<BoardDTO> search(String boardTitle) {
        // 검색결과를 담을 bookDTOS 라는 List 선언
        List<BoardDTO> boardDTOS = new ArrayList<>();
        for (int i = 0; i < boardDTOList.size(); i++) {
            // 저장되어 있는 글제목에 검색어가 포함되어 있으면 true
            if (boardDTOList.get(i).getBoardTitle().contains(boardTitle)) {
                // 조건을 만족하면 boardDTOS 에 추가
                BoardDTO boardDTO = boardDTOList.get(i);
                // boardDTO로 꺼낸 값을 boardDTOS에 추가하기 위해 사용.
                boardDTOS.add(boardDTO);
                // 위의 두 작업을 한 번에 한 문장.
//                boardDTOS.add(boardDTOList.get(i));
            }
        }
        return boardDTOS;
    }
}
