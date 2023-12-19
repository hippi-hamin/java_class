package ch12_classes.ex04;

public class BoardDTO {
    //필드
    private Long id; // 글번호
    private String boardTitle; // 제목
    private String boardWriter; // 작성자
    private String boardContents; // 내용
    private String boardPass; // 비밀번호
    private int boardHits; // 조회수

    // getter/setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardWriter() {
        return boardWriter;
    }

    public void setBoardWriter(String boardWriter) {
        this.boardWriter = boardWriter;
    }

    public String getBoardContents() {
        return boardContents;
    }

    public void setBoardContents(String boardContents) {
        this.boardContents = boardContents;
    }

    public String getBoardPass() {
        return boardPass;
    }

    public void setBoardPass(String boardPass) {
        this.boardPass = boardPass;
    }

    public int getBoardHits() {
        return boardHits;
    }

    public void setBoardHits() {
        this.boardHits++;
    }

    // 기본생성자
    public BoardDTO(){
    }

    // idValue 절댓값으로 삼아 값을 중가시키는 메서드
    public static Long idValue = 1L;
    // 필드 값을 매개변수로 갖는 기본 생성자
    public BoardDTO(String boardTitle, String boardWriter, String boardContents, String boardPass) {
        this.id = idValue++;
        this.boardTitle = boardTitle;
        this.boardWriter = boardWriter;
        this.boardContents = boardContents;
        this.boardPass = boardPass;
    }

    // toString
    @Override
    public String toString() {
        return "BoardDTO{" +
                "id=" + id +
                ", boardTitle='" + boardTitle + '\'' +
                ", boardWriter='" + boardWriter + '\'' +
                ", boardHits=" + boardHits +
                '}';
    }
}
