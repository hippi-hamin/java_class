package ch12_classes.ex06_memberboard.repository;

import ch12_classes.ex06_memberboard.common.CommonVariables;
import ch12_classes.ex06_memberboard.dto.BoardDTO;
import ch12_classes.ex06_memberboard.dto.CommentDTO;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
    private static List<BoardDTO> boardDTOList = new ArrayList<>();
    private static List<CommentDTO> commentDTOList = new ArrayList<>();

    public static boolean save(BoardDTO boardDTO) {
        return boardDTOList.add(boardDTO);
    }

    public List<BoardDTO> findAll() {
        return boardDTOList;
    }

    public boolean updateHits(Long id) {
        boolean result = false;
        for (int i = 0; i < boardDTOList.size(); i++) {
            if (id.equals(boardDTOList.get(i).getId())) {
                int hits = boardDTOList.get(i).getBoardHits();
                hits = hits + 1;
                boardDTOList.get(i).setBoardHits(hits);
                result = true;
            }
        }
        return result;
    }

    public BoardDTO findById(Long id) {
        for (int i = 0; i < boardDTOList.size(); i++) {
            if (id.equals(boardDTOList.get(i).getId())) {
                return boardDTOList.get(i);
            }
        }
        return null;
    }

    public boolean update(Long id, String updateTitle, String updateContents) {
        boolean result = false;
        for (int i = 0; i < boardDTOList.size(); i++) {
            // memberDTOList.get(i) 인덱스에서 LoginEmail과 같은 memberEmail 정보를 찾는 문장
            if (id.equals(boardDTOList.get(i).getId())) {
                // boardDTOList.get(i) = 해당 인덱스에 접근 하여
                // setBoardTitle(updateTitle) = 해당 인덱스에 BoardTitle 값을 updateTitle 값으로 변경.
                boardDTOList.get(i).setBoardTitle(updateTitle);
                // setBoardContents(updateContents) = 해당 인덱스에 BoardContents값을 updateContents 값으로 변경.
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
        List<BoardDTO> searchList = new ArrayList<>();
        for (int i = 0; i < boardDTOList.size(); i++) {
            // 저장되어 있는 글제목에 검색어가 포함되어 있으면 true
            if (boardDTOList.get(i).getBoardTitle().contains(boardTitle)) {
                // 조건을 만족하면 boardDTO 에 추가
                BoardDTO boardDTO = boardDTOList.get(i);
                // boardDTO 값을 searchList에 추가하기 위해 사용.
                searchList.add(boardDTO);
                // 위의 두 작업을 한 번에 한 문장.
//                boardDTOS.add(boardDTOList.get(i));
            }
        }
        return searchList;
    }

    public boolean comment(CommentDTO commentDTO) {
        return commentDTOList.add(commentDTO);
    }

    public List<CommentDTO> commentList() {
        return commentDTOList;
    }
}
