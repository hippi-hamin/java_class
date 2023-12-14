package ch11_array.ex3;
/**
 책 클래스
 필드
 책관리번호(id) - Long 타입
 책제목(bookTitle)
 저자(bookAuthor)
 가격(bookPrice)
 출판사(bookPublisher)
 필드에 대한 getter/setter
 생성자 2가지
 toString method
 */

public class Book {
    // 필드
    private Long id;
    private String bookTitle;
    private String bookAuthor;
    private int bookPrice;
    private String bookpublisher;

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

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookpublisher() {
        return bookpublisher;
    }

    public void setBookpublisher(String bookpublisher) {
        this.bookpublisher = bookpublisher;
    }

    private static Long idValue = 1L;

    // 기본생성자
    public Book(){
        this.id = idValue++; // 생성자 밖에 private static Long idValue = 1L; 있어서 사용 가능
    }
    // 필드의 모든 값을 매개변수로 갖는 Book 생성자
    public Book(String bookTitle, String bookAuthor, int bookPrice, String bookpublisher) {
        this.id = idValue++;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.bookpublisher = bookpublisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrice='" + bookPrice + '\'' +
                ", bookpublisher='" + bookpublisher + '\'' +
                '}';
    }
}
