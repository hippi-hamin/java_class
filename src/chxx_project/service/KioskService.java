package chxx_project.service;

import ch12_classes.ex06_memberboard.dto.BoardDTO;
import chxx_project.dto.CoffeeDTO;
import chxx_project.dto.DessertDTO;
import chxx_project.dto.TeaDTO;
import chxx_project.repository.KioskRepository;
import chxx_project.repository.MenuRepository;

import java.util.List;
import java.util.Scanner;

import static chxx_project.repository.MenuRepository.*;

public class KioskService {
    Scanner sc = new Scanner(System.in);
    KioskRepository kioskRepository = new KioskRepository();

    public void findAll() {
        System.out.println("커피");
        List<CoffeeDTO> coffeeDTOList = kioskRepository.findAllCoffee();
        for (CoffeeDTO coffeeDTO : coffeeDTOList) {
            System.out.println(coffeeDTO.getCoffeeName());
        }
        System.out.println("차");
        List<TeaDTO> teaDTOList = kioskRepository.findAllTea();
        for (TeaDTO teaDTO : teaDTOList) {
            System.out.println(teaDTO.getTeaName());
        }
        System.out.println("디저트");
        List<DessertDTO> dessertDTOList = kioskRepository.findAllDessert();
        for (DessertDTO dessertDTO : dessertDTOList) {
            System.out.println(dessertDTO.getDessertName());
        }
    }

    public void coffeeAll() {
        List<CoffeeDTO> coffeeDTOList = kioskRepository.findAllCoffee();
        for (CoffeeDTO coffeeDTO : coffeeDTOList) {
            System.out.println(coffeeDTO.getCoffeeName());
        }
    }

    public void teaAll() {
        List<TeaDTO> teaDTOList = kioskRepository.findAllTea();
        for (TeaDTO teaDTO : teaDTOList) {
            System.out.println(teaDTO.getTeaName());
        }
    }

    public void dessertAll() {
        List<DessertDTO> dessertDTOList = kioskRepository.findAllDessert();
        for (DessertDTO dessertDTO : dessertDTOList) {
            System.out.println(dessertDTO.getDessertName());
        }
    }

    public void search() {
        System.out.print("검색할 이름 : ");
        String menuName = sc.next();
        // 검색 결과가 여러 개 일 수 있기 때문에 List 메서드를 사용해 줌.
        List<CoffeeDTO> searchList1 = kioskRepository.search1(menuName);
        List<TeaDTO> searchList2 = kioskRepository.search2(menuName);
        List<DessertDTO> searchList3 = kioskRepository.search3(menuName);
        System.out.println("검색 결과 : ");
        if (searchList1.size() > 0 && searchList2.size() > 0 && searchList3.size() > 0) {
            System.out.println("종류\t" + "이름\t" + "가격\t");
            listPrint1(searchList1);
            listPrint2(searchList2);
            listPrint3(searchList3);
        } else if (searchList1.size() > 0 && searchList2.size() > 0 && searchList3.size() == 0) {
            System.out.println("종류\t" + "이름\t" + "가격\t");
            listPrint1(searchList1);
            listPrint2(searchList2);
        } else if (searchList1.size() > 0 && searchList2.size() == 0 && searchList3.size() > 0) {
            System.out.println("종류\t" + "이름\t" + "가격\t");
            listPrint1(searchList1);
            listPrint3(searchList3);
        } else if (searchList1.size() == 0 && searchList2.size() > 0 && searchList3.size() > 0) {
            System.out.println("종류\t" + "이름\t" + "가격\t");
            listPrint2(searchList2);
            listPrint3(searchList3);
        } else if (searchList1.size() > 0 && searchList2.size() == 0 && searchList3.size() == 0) {
            System.out.println("종류\t" + "이름\t" + "가격\t");
            listPrint1(searchList1);
        } else if (searchList2.size() > 0 && searchList1.size() == 0 && searchList3.size() == 0) {
            System.out.println("종류\t" + "이름\t" + "가격\t");
            listPrint2(searchList2);
        } else if (searchList3.size() > 0 && searchList1.size() == 0 && searchList2.size() == 0) {
            System.out.println("종류\t" + "이름\t" + "가격\t");
            listPrint3(searchList3);
        } else if (searchList1.size() == 0 && searchList2.size() == 0 && searchList3.size() == 0) {
            System.out.println("없습니다!");
        }
    }

    private void listPrint1(List<CoffeeDTO> searchList1) {
        for (CoffeeDTO coffeeDTO : searchList1) {
            System.out.println(coffeeDTO.getCategory() + "\t" + coffeeDTO.getCoffeeName() + "\t" + coffeeDTO.getCoffeePrice());
        }
    }

    private void listPrint2(List<TeaDTO> searchList2) {
        for (TeaDTO teaDTO : searchList2) {
            System.out.println(teaDTO.getCategory() + "\t" + teaDTO.getTeaName() + "\t" + teaDTO.getTeaPrice());
        }
    }

    private void listPrint3(List<DessertDTO> searchList3) {
        for (DessertDTO dessertDTO : searchList3) {
            System.out.println(dessertDTO.getCategory() + "\t" + dessertDTO.getDessertName() + "\t" + dessertDTO.getDessertPrice());
        }
    }
}
