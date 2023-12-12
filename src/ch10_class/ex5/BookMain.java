package ch10_class.ex5;

public class BookMain {
    public static void main(String[] args) {
        // 책 정보는 시중에 있는 실제 책으로 해봅시다.

        // 기본생성자로 객체 만들고 필드값 채우기
        Book book1 = new Book();
        book1.bookTitle = "어린왕자";
        book1.bookAuthor = "앙투안 마리 드 생텍쥐페리";
        book1.bookPublisher = "뜻밖";
        book1.isbn = "979-11-92684-04-8";
        book1.bookPrice = 9700;

        // 매개변수 2개 있는 생성자로 객체 만들고 필드값 채우기
        Book book2 = new Book("어린왕자", "앙투안 마리 드 생텍쥐페리");

        // 모든 매개변수 있는 생성자로 객체 만들고 필드값 채우기
        Book book3 = new Book("어린왕자", "앙투안 마리 드 생텍쥐페리", "뜻밖", "979-11-92684-04-8", 9700);
    }
}
