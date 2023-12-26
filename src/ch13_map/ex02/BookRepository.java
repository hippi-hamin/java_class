package ch13_map.ex02;

import java.util.HashMap;
import java.util.Map;

public class BookRepository {
    // key(고유값이 있는 형식이 좋음) : Long, Value : BookDTO
    private static Map<Long, BookDTO> bookDTOMap = new HashMap<>();

    public boolean save(BookDTO bookDTO) {
        System.out.println("bookDTO" + bookDTO);
        BookDTO dto = bookDTOMap.put(bookDTO.getId(), bookDTO);
        System.out.println("dto = " + dto);
        if (dto == null) {
            return true;
        } else {
            return false;
        }
    }

    public Map<Long, BookDTO> findAll() {
        return bookDTOMap;
    }

    public BookDTO findById(Long id) {
        // map에서 조회하려는 id와 일치하는 것을 찾아서 BookDTO 객체 리턴
        for (Long i : bookDTOMap.keySet()) {
            if (id.equals(bookDTOMap.get(i).getId())) {
                return bookDTOMap.get(i);
            }
        }
        return null;
    }
}
