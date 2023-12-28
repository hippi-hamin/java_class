package chxx_project.repository;

import chxx_project.dto.CoffeeDTO;
import chxx_project.dto.DessertDTO;
import chxx_project.dto.TeaDTO;

import java.util.ArrayList;
import java.util.List;

public class KioskRepository {
    List<CoffeeDTO> coffeeDTOList = MenuRepository.coffeeDTOList;
    List<TeaDTO> teaDTOList = MenuRepository.teaDTOList;
    List<DessertDTO> dessertDTOList = MenuRepository.dessertDTOList;

    public List<CoffeeDTO> findAllCoffee() {
        return coffeeDTOList;
    }

    public List<TeaDTO> findAllTea() {
        return teaDTOList;
    }

    public List<DessertDTO> findAllDessert() {
        return dessertDTOList;
    }

    public List<CoffeeDTO> search1(String menuName) {
        List<CoffeeDTO> searchList1 = new ArrayList<>();
        for (int i = 0; i < coffeeDTOList.size(); i++) {
            if (coffeeDTOList.get(i).getCoffeeName().contains(menuName)) {
                CoffeeDTO coffeeDTO = coffeeDTOList.get(i);
                searchList1.add(coffeeDTO);
                // 위의 두 작업을 한 번에 한 문장.
//                boardDTOS.add(boardDTOList.get(i));
            }
        }
        return searchList1;
    }

    public List<TeaDTO> search2(String menuName) {
        // 검색결과를 담을 bookDTOS 라는 List 선언
        List<TeaDTO> searchList2 = new ArrayList<>();
        for (int i = 0; i < teaDTOList.size(); i++) {
            // 저장되어 있는 글제목에 검색어가 포함되어 있으면 true
            if (teaDTOList.get(i).getTeaName().contains(menuName)) {
                // 조건을 만족하면 boardDTO 에 추가
                TeaDTO teaDTO = teaDTOList.get(i);
                searchList2.add(teaDTO);
                // 위의 두 작업을 한 번에 한 문장.
//                boardDTOS.add(boardDTOList.get(i));
            }
        }
        return searchList2;


    }

    public List<DessertDTO> search3(String menuName) {
        // 검색결과를 담을 bookDTOS 라는 List 선언
        List<DessertDTO> searchList3 = new ArrayList<>();
        for (int i = 0; i < dessertDTOList.size(); i++) {
            // 저장되어 있는 글제목에 검색어가 포함되어 있으면 true
            if (dessertDTOList.get(i).getDessertName().contains(menuName)) {
                DessertDTO dessertDTO = dessertDTOList.get(i);
                searchList3.add(dessertDTO);
//                boardDTOS.add(boardDTOList.get(i));
            }
        }
        return searchList3;
    }
}
