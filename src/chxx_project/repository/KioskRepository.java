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
            }
        }
        return searchList1;
    }

    public List<TeaDTO> search2(String menuName) {
        List<TeaDTO> searchList2 = new ArrayList<>();
        for (int i = 0; i < teaDTOList.size(); i++) {
            if (teaDTOList.get(i).getTeaName().contains(menuName)) {
                TeaDTO teaDTO = teaDTOList.get(i);
                searchList2.add(teaDTO);
            }
        }
        return searchList2;


    }

    public List<DessertDTO> search3(String menuName) {
        List<DessertDTO> searchList3 = new ArrayList<>();
        for (int i = 0; i < dessertDTOList.size(); i++) {
            // 저장되어 있는 글제목에 검색어가 포함되어 있으면 true
            if (dessertDTOList.get(i).getDessertName().contains(menuName)) {
                DessertDTO dessertDTO = dessertDTOList.get(i);
                searchList3.add(dessertDTO);
            }
        }
        return searchList3;
    }

    public int basket1(String coffeeName, int coffeeCount) {
        int coffeePrice = 0;
        for (int i = 0; i < coffeeDTOList.size(); i++) {
            if (coffeeDTOList.get(i).getCoffeeName().contains(coffeeName)) {
                int price = coffeeDTOList.get(i).getCoffeePrice();
                coffeePrice = price * coffeeCount;
            }
        }
        return coffeePrice;
    }

    public int basket2(String teaName, int teaCount) {
        int teaPrice = 0;
        for (int i = 0; i < teaDTOList.size(); i++) {
            if (teaDTOList.get(i).getTeaName().contains(teaName)) {
                int price = teaDTOList.get(i).getTeaPrice();
                teaPrice = price * teaCount;
            }
        }
        return teaPrice;
    }
    public int basket3(String dessertName, int teaCount) {
        int dessertPrice = 0;
        for (int i = 0; i < dessertDTOList.size(); i++) {
            if (dessertDTOList.get(i).getDessertName().contains(dessertName)) {
                int price = dessertDTOList.get(i).getDessertPrice();
                dessertPrice = price * teaCount;
            }
        }
        return dessertPrice;
    }
}
