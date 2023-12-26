package ch13_map.ex02;

import java.util.Map;
import java.util.Scanner;

public class BookService {
    Scanner sc = new Scanner(System.in);
    BookRepository bookRepository = new BookRepository();

    public void save() {
        System.out.print("도서명 : ");
        String bookTitle = sc.next();
        System.out.print("저자 : ");
        String bookAuthor = sc.next();
        System.out.print("가격(숫자만 입력하시오.) : ");
        int bookPrice = sc.nextInt();
        System.out.print("출판사 : ");
        String bookPublisher = sc.next();
        // 나중엔 DTO클래스를 여러 개도 만들 수 있음.
        // 우리 Book이라는 클래스를 사용할 때 이 형식으로 사용할 것이라는 의미
        BookDTO bookDTO = new BookDTO(bookTitle, bookAuthor, bookPrice, bookPublisher);
        // bookRepository를 호출하면서 bookDTO를 넘겨주고, result로 받겠다.
        boolean result = bookRepository.save(bookDTO);

        if (result) {
            System.out.println("책등록 성공");
        } else {
            System.out.println("책등록 실패");
        }
    }

    public void findAll() {
        Map<Long, BookDTO> bookDTOMap = bookRepository.findAll();
        for (Long i : bookDTOMap.keySet()) {
            System.out.println(bookDTOMap.get(i));
            // 도서 제목만 본다면
            System.out.println(bookDTOMap.get(i).getBookTitle());
        }
    }

    public void findById() {
        System.out.print("조회 id: ");
        Long id = sc.nextLong();
        BookDTO bookDTO = bookRepository.findById(id);
        if (bookDTO != null) {
            System.out.println("bookDTO = " + bookDTO);
        } else {
            System.out.println("조회결과가 없습니다!");
        }
    }

}
