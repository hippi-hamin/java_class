package ch12_classes.ex02;

import ch11_array.ex3.Book;
import ch12_classes.ex01.StudentDTO;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    // 도서 정보를 관리하는 bookDTOList

    /**
     * 도서등록 메서드
     * name: save
     * parameter: BookDTO
     * return: boolean
     * 실행내용
     * Service로 부터 전달 받은 DTO 객체를 리스트에 저장하고 결과를 리턴
     */
    private static List<BookDTO> bookDTOList = new ArrayList<>();

    public boolean save(BookDTO bookDTO) {
        return bookDTOList.add(bookDTO);
    }

    /**
     * 도서목록 메서드
     * name: findAll
     * parameter: x
     * return: List<BookDTO>
     * 실행내용
     * Service로 부터 호출되면 리스트를 리턴
     */
    public static List<BookDTO> findAll() {
        return bookDTOList;
    }

    /**
     * 도서조회 메서드
     * name: findById
     * parameter: Long
     * return: BookDTO
     * 실행내용
     * Service로 부터 id를 전달받고 일치하는 결과를 찾아서 DTO를 리턴
     * 없으면 null 리턴
     */
    public BookDTO findById(Long id) {
        BookDTO bookDTO = null;
//        for (int i = 0; i < bookDTOList.size(); i++) {
//            if (id.equals(bookDTOList.get(i).getId())) {
//                bookDTO = bookDTOList.get(i);
//            }
//        }
        // foreach
        for (BookDTO bookDTO1 : bookDTOList) {
            if (id.equals(bookDTO1.getId())) {
                bookDTO = bookDTO1;
            }
        }
        return bookDTO;
    }

    /**
     * 도서조회 메서드
     * name: findByTitle
     * parameter: String
     * return: BookDTO
     * 실행내용
     * Service로 부터 도서제목을 전달받고 일치하는 결과를 찾아서 DTO를 리턴
     * 없으면 null 리턴
     */
    public BookDTO findByTitle(String bookTitle) {
        // id 와 일치하는 데이터가 있으면 해당 DTO - 객체를 리턴하고
        // 없으면 null을 리턴함
        BookDTO bookDTO = null;
        for (int i = 0; i < bookDTOList.size(); i++) {
            if (bookTitle.equals(bookDTOList.get(i).getBookTitle())) {
                bookDTO = bookDTOList.get(i);
            }
        }
        return bookDTO;
    }

    public List<BookDTO> search(String bookTitle) {
        // 검색결과를 담을 bookDTOS 라는 List 선언
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (int i = 0; i < bookDTOList.size(); i++) {
            // 저장되어 있는 도서명에 검색어가 포함되어 있으면 true
            if (bookDTOList.get(i).getBookTitle().contains(bookTitle)) {
                // 조건을 만족하면 bookDTOS 에 추가
                BookDTO bookDTO = bookDTOList.get(i);
                // bookDTO로 꺼낸 값을 bookDTOS에 추가하기 위해 사용.
                bookDTOS.add(bookDTO);
                // 위의 두 작업을 한 번에 한 문장.
//                bookDTOS.add(bookDTOList.get(i));
            }
        }
        return bookDTOS;
    }

    public boolean update(Long id, int bookPrice) {
        boolean result = false;
        for (int i = 0; i < bookDTOList.size(); i++) {
            // bookDTOList.get(i) 인덱스 안에 id 정보를 찾는 문장
            if (id.equals(bookDTOList.get(i).getId())) {

                // bookDTOList.get(i) = 해당 인덱스에 접근을 해서,
                // setBookPrice(bookPrice) = 해당 데이터에 price 값을 바꾸기.
                bookDTOList.get(i).setBookPrice(bookPrice);
                result = true;
            }
        }
        return result;
    }

    public boolean delete(Long id) {
        boolean result = false;
        for (int i = 0; i < bookDTOList.size(); i++) {
            if (id.equals(bookDTOList.get(i).getId())) {
                bookDTOList.remove(i);
            }
        }
        return result;
    }
}

