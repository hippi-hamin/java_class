package ch12_classes.ex02;

import ch12_classes.ex01.StudentDTO;

import java.util.List;
import java.util.Scanner;

public class BookService {
    /**
     * 도서등록 메서드
     * name: save
     * parameter: x
     * return: x
     * 실행내용
     * 스캐너로 도서명, 저자, 가격, 출판사정보를 입력받고
     * BookDTO 객체에 담아서 Repository로 전달하여 저장이 되도록 함
     * 등록 여부를 출력한다.(등록성공 or 등록실패)
     */
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

    /**
     * 도서목록 메서드
     * name: findAll
     * parameter: x
     * return: x
     * 실행내용
     * Repository로 부터 목록을 리턴 받아서 목록에 있는 모든 정보를 출력
     */
    public void findAll() {
        List<BookDTO> bookDTOList = bookRepository.findAll();
        for (BookDTO bookDTO : bookDTOList) {
            System.out.println("bookDTO = " + bookDTO);
        }
    }


    /**
     * 도서조회 메서드
     * name: findById
     * parameter: x
     * return: x
     * 실행내용
     * id를 입력받고 Repository로 부터 id에 해당 하는 도서 정보를 출력
     * 없으면 없다고 출력
     */

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

    /**
     * 도서조회 메서드
     * name: findByTitle
     * parameter: x
     * return: x
     * 실행내용
     * 도서제목을 입력받고 Repository로 부터 해당 하는 도서 정보를 출력(제목이 정확히 일치하는 것만)
     * 없으면 없다고 출력
     */
    public void findByTitle() {
        System.out.print("도서명: ");
        String bookTitle = sc.next();
        BookDTO bookDTO = bookRepository.findByTitle(bookTitle);
        if (bookDTO != null) {
            // 조회결과 있음
            System.out.println("bookDTO = " + bookDTO);
        } else {
            // 조회결과 없음
            System.out.println("조회결과가 없습니다!");
        }
    }

    public void search() {
        System.out.print("검색어 : ");
        String bookTitle = sc.next();
        // 검색 결과가 여러 개 일 수 있기 때문에 List 메서드를 사용해 줌.
        List<BookDTO> bookDTOList = bookRepository.search(bookTitle);
        if (bookDTOList.size() > 0) {
            for (BookDTO bookDTO : bookDTOList) {
                System.out.println("bookDTO = " + bookDTO);
            }
        } else {
            // bookDTOList.size() == 0 => 결과가 없다
            System.out.println("검색 결과가 없습니다!");
        }
    }

    public void update() {
        // 수정할 id를 입력받음
        // 해당 id 도서가 있다면 수정할 가격을 입력받고 수정 처리
        // 없으면 없다고 출력
        System.out.print("수정할 id : ");
        Long id = sc.nextLong();
        // 위에서 받은 id 값을 갖고 있는 책이 있는 지 찾는 문장
        BookDTO bookDTO = bookRepository.findById(id);
        if (bookDTO != null) {
            // 조회결과 있음
            System.out.println("수정할 가격 : ");
            int bookPrice = sc.nextInt();
            // 지정한 id의 책만 가격을 수정해야 되기 때문에 id 값과 bookPrice 값을 같이 보내주어야 함.
            boolean updateResult = bookRepository.update(id, bookPrice);
            if (updateResult) {
                System.out.println("수정되었습니다.");
            } else {
                System.out.println("수정 실패하였습니다.");
            }
        } else {
            // 조회결과 없음
            System.out.println("조회결과가 없습니다!");
        }
    }

    public void delete() {
        System.out.println("삭제할 id : ");
        Long id = sc.nextLong();
        boolean result = bookRepository.delete(id);
        if (result) {
            System.out.println("삭제 성공");
        } else {
            System.out.println("삭제 실패");
        }
    }
}