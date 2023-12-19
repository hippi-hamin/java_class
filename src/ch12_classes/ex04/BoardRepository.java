package ch12_classes.ex04;

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
}
