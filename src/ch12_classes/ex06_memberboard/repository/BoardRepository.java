package ch12_classes.ex06_memberboard.repository;

import ch12_classes.ex06_memberboard.common.CommonVariables;
import ch12_classes.ex06_memberboard.dto.BoardDTO;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
    private static List<BoardDTO>boardDTOList = new ArrayList<>();
    public static boolean save(BoardDTO boardDTO) {
        return boardDTOList.add(boardDTO);
    }
}
