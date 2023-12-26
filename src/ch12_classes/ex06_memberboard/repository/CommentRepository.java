package ch12_classes.ex06_memberboard.repository;

import ch12_classes.ex06_memberboard.dto.CommentDTO;

import java.util.ArrayList;
import java.util.List;

public class CommentRepository {
    List<CommentDTO> commentDTOList = new ArrayList<>();

    public boolean comment(CommentDTO commentDTO) {
        return commentDTOList.add(commentDTO);
    }

    public List<CommentDTO> commentList(Long boardId) {
        List<CommentDTO> commentDTOS = new ArrayList<>();
        for (int i = 0; i < commentDTOList.size(); i++) {
            if (boardId.equals(commentDTOList.get(i).getBoardId())) {
                commentDTOS.add(commentDTOList.get(i));
            }
        }
        return commentDTOList;
    }
}
