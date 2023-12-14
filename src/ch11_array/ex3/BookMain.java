package ch11_array.ex3;

import java.util.ArrayList;
import java.util.List;

public class BookMain {
    // Book 객체를 담기위한 bookList 객체 선언

    // 기본생성자로 Book 객체(book1) 생성 후 bookList에 추가

    // 매개변수 생성자로 Book 객체(book2) 생성 후 bookList에 추가

    // for을 이용하여 bookList의 전체 데이터 출력

    // for each를 이용하여 bookList의 전체 데이터 출력

    // list의 0번 인덱스에 담긴 책의 가격을 50000으로 변경

    // list의 1번 인덱스에 담긴 출판사의 제목을 "안녕출판사"로 변경

    // for를 이용하여 bookList의 전체 데이터 출력

    // for each를 이용하여 bookList의 전체 데이터 출력

    public static void main(String[] args) {
        // bookList에 Book 객체 담기
        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book();
        // 기본생성자로 객체(book1)생성
        book1.setId(1L);
        book1.setBookTitle("어린왕자");
        book1.setBookAuthor("앙투안 드 생텍쥐페리");
        book1.setBookPrice(10620);
        book1.setBookpublisher("열린책들");
        // bookList 라는 ArrayList 에 book1추가
        bookList.add(book1);
        // 매개변수를 가진 생성자 Book의 객체(book2) 생성
        Book book2 = new Book("내가 생각한 인생이 아니야", "류시화", 16200, "수오서재");
        // bookList 에 book2 추가
        bookList.add(book2);
        // 매개변수를 가진 생성자 Book의 객체(book3) 생성
        Book book3 = new Book("무서운 게 딱 좋아", "이구성",8000, "아이엘비");
        // bookList 에 book3 추가
        bookList.add(book3);

        // for문을 써서 bookList 전체 데이터 값 출력
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println("book" + (i+1) + " = " + bookList.get(i));
        }
        // for each를 사용하여 bookList에 전체 데이터 출력
        for (Book a : bookList) {
            System.out.println("book = " + a);
        }
        // List의 0번 인덱스에 담긴 책의 가격을 50000으로 변경
        bookList.get(0).setBookPrice(50000);
        // 변경된 값 확인
        System.out.println("book1 price = " + bookList.get(0).getBookPrice());
        // List의 1번 인덱스에 담긴 출판사의 제목을 "안녕출판사"로 변경
        bookList.get(1).setBookpublisher("안녕출판사");
        // 변경된 값 확인
        System.out.println("book2 publisher = " + bookList.get(1).getBookpublisher());
        // for 로 bookList 전체 데이터 출력
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println("book" + (i+1) + " = " + bookList.get(i));
        }
        // for each를 이용하여 bookList의 전체 데이터 출력
        for (Book a : bookList) {
            System.out.println("book = " + a);
        }
    }
}
