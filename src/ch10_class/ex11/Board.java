package ch10_class.ex11;
/**
 게시글 클래스
 필드
 글번호(id) - Long 타입
 제목(boardTitle)
 작성자(boardWriter)
 내용(boardContents)
 조회수(boardHits)
 필드에 대한 getter/setter
 생성자 2가지
 toString method
 글조회 method
 name: findById
 parameter: id
 return: x
 실행내용
 main으로부터 글번호를 전달받고 글번호가 일치하면 해당 게시글의 내용을
 print로 출력해준다.
 단 출력하기 전에 조회수 값을 1 증가 시켜야 한다.
 */
public class Board {
    // 필드
    private Long id; // Long으로 한 이유는 int는 21억까지밖에 안되기 때문에
    private String boardTitle;
    private String boardWriter;
    private String boardContents;
    private int boardHits;

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

    public int getBoardHits() {
        return boardHits;
    }

    public void setBoardHits(int boardHits) {
        this.boardHits = boardHits;
    }

    // 기본생성자
    public Board(){
    }

    // 필드값을 전부 매개변수로 갖는 생성자
    public Board(Long id, String boardTitle, String boardWriter, String boardContents, int boardHits) {
        this.id = id;
        this.boardTitle = boardTitle;
        this.boardWriter = boardWriter;
        this.boardContents = boardContents;
        this.boardHits = boardHits;
    }

    // 모든 필드값을 담는 print() 메서드
    public void print(){
        System.out.println("글번호 : " + id + " |" + " 제목 : " + boardTitle + " |" + " 작성자 : " + boardWriter + " |" + " 내용 : " + boardContents + " |" + " 조회수 : " + boardHits);
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", boardTitle='" + boardTitle + '\'' +
                ", boardWriter='" + boardWriter + '\'' +
                ", boardContents='" + boardContents + '\'' +
                ", boardHits=" + boardHits +
                '}';
    }
    public boolean findById(Long id){
        if(id.equals(this.id)){
            boardHits++;
            return true;
        } else {
            return false;
        }
    }
}
