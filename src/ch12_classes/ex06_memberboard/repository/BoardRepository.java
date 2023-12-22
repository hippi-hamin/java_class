package ch12_classes.ex06_memberboard.repository;

import ch12_classes.ex06_memberboard.common.CommonVariables;
import ch12_classes.ex06_memberboard.dto.BoardDTO;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
    private static List<BoardDTO> boardDTOList = new ArrayList<>();

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
}
