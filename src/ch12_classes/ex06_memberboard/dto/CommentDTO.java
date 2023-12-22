package ch12_classes.ex06_memberboard.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommentDTO {
    // 필드
    private Long id;
    private Long boardId;
    private String commentWriter;
    private String commentContents;
    private String commentCreatedAt;

    // getter/setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public String getCommentWriter() {
        return commentWriter;
    }

    public void setCommentWriter(String commentWriter) {
        this.commentWriter = commentWriter;
    }

    public String getCommentContents() {
        return commentContents;
    }

    public void setCommentContents(String commentContents) {
        this.commentContents = commentContents;
    }

    public String getCommentCreatedAt() {
        return commentCreatedAt;
    }

    public void setCommentCreatedAt(String commentCreatedAt) {
        this.commentCreatedAt = commentCreatedAt;
    }

    // 기본생성자
    public CommentDTO(){

    }

    public static Long idValue = 1L;
    // 필드값을 매개변수로 갖는 생성자
    public CommentDTO(Long boardId, String commentWriter, String commentContents) {
        this.id = idValue++;
        this.boardId = boardId;
        this.commentWriter = commentWriter;
        this.commentContents = commentContents;
        this.commentCreatedAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    // toString
    @Override
    public String toString() {
        return "CommentDTO{" +
                "id=" + id +
                ", boardId='" + boardId + '\'' +
                ", commentWriter='" + commentWriter + '\'' +
                ", commentContents='" + commentContents + '\'' +
                ", commentCreatedAt='" + commentCreatedAt + '\'' +
                '}';
    }
}
