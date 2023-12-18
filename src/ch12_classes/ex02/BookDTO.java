package ch12_classes.ex02;

public class BookDTO {
    /**
     * 도서 클래스
     * 필드
     * 도서관리번호(id) - Long 타입
     * 도서명(bookTitle)
     * 저자(bookAuthor)
     * 가격(bookPrice)
     * 출판사(bookPublisher)
     * 필드에 대한 getter/setter
     * 생성자 2가지
     * 도서 등록은 매개변수 있는 생성자로만 할 수 있음.(id는 자동으로 하나씩 증가)
     * toString method
     */

    //필드
    private Long id;
    private String bookTitle;
    private String bookAuthor;
    private int bookPrice;
    private String bookPublisher;

    // getter/setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int price) {
        this.bookPrice = bookPrice;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    // 기본생성자
    public BookDTO() {
    }

    // static 을 써줌으로 써 스택, 힙 영역이 아닌 메서드 영역에 저장함으로써 값을 유지할 수 있게 해줌.
    public static Long idValue = 1L;
    // 필드값을 매개변수로 갖고 있는 BookDTO 생성자
    public BookDTO(String bookTitle, String bookAuthor, int bookPrice, String bookPublisher) {
        this.id = idValue++;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.bookPublisher = bookPublisher;
    }

    // toString
    @Override
    public String toString() {
        return "책 번호 : " + id +
                ", 제목 : '" + bookTitle + '\'' +
                ", 저자 : '" + bookAuthor + '\'' +
                ", 가격 : " + bookPrice +
                ", 출판사 : '" + bookPublisher + '\'';
    }
}
