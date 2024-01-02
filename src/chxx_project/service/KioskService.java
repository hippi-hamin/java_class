package chxx_project.service;

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

    public void basket() {
        int coffeePrice = 0;
        int teaPrice = 0;
        int dessertPrice = 0;
        boolean run = true;
        boolean run2 = true;
        MenuRepository menuRepository = new MenuRepository();
        while (run) {
            int totalPrice = coffeePrice + teaPrice + dessertPrice;
            System.out.println("원하는 메뉴를 입력해주세요");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("1.커피 | 2.차 | 3.디저트 | 0.쇼핑종료");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.print("선택> ");
            int selectNo = sc.nextInt();
            if (selectNo == 1) {
                while (run2) {
                    System.out.println("원하는 커피의 이름을 입력하세요.");
                    String coffeeName = sc.next();
                    boolean coffeeNameCheck = menuRepository.coffeeNameCheck(coffeeName);
                    if (coffeeNameCheck) {
                        System.out.println("주문할 양을 입력해 주세요.");
                        int coffeeCount = sc.nextInt();
                        coffeePrice = kioskRepository.basket1(coffeeName, coffeeCount);
                    } else {
                        System.out.println("없는 메뉴입니다.");
                    }
                    System.out.println("주문을 마치시겠습니까? 1.yes | 2.no");
                    selectNo = sc.nextInt();
                    if (selectNo == 1) {
                        coffeePrice += coffeePrice;
                        run2 = false;
                    } else if (selectNo == 2) {
                        System.out.println("추가로 주문해주세요.");
                    }
                }
            } else if (selectNo == 2) {
                while (run2) {
                    System.out.println("원하는 차의 이름을 입력하세요.");
                    String teaName = sc.next();
                    boolean teaNameCheck = menuRepository.teaNameCheck(teaName);
                    if (teaNameCheck) {
                        System.out.println("주문할 양을 입력해주세요.");
                        int teaCount = sc.nextInt();
                        teaPrice = kioskRepository.basket2(teaName, teaCount);
                    } else {
                        System.out.println("없는 메뉴입니다.");
                    }
                    System.out.println("주문을 마치시겠습니까? 1.yes | 2.no");
                    selectNo = sc.nextInt();
                    if (selectNo == 1) {
                        teaPrice += teaPrice;
                        run2 = false;
                    } else if (selectNo == 2) {
                        System.out.println("추가로 주문해주세요.");
                    }
                }
            } else if (selectNo == 3) {
                while (run2) {
                    System.out.println("원하는 디저트의 이름을 입력하세요.");
                    String dessertName = sc.next();
                    boolean dessertNameCheck = menuRepository.dessertNameCheck(dessertName);
                    if (dessertNameCheck) {
                        System.out.println("주문할 양을 입력하세요.");
                        int dessertCount = sc.nextInt();
                        dessertPrice = kioskRepository.basket3(dessertName, dessertCount);
                    } else {
                        System.out.println("없는 메뉴입니다.");
                    }
                    System.out.println("주문을 마치시겠습니까? 1.yes | 2.no");
                    selectNo = sc.nextInt();
                    if (selectNo == 1) {
                        dessertPrice += dessertPrice;
                        run2 = false;
                    } else if (selectNo == 2) {
                        System.out.println("추가로 주문해주세요.");
                    }
                }
            } else if (selectNo == 0) {
                totalPrice = coffeePrice + teaPrice + dessertPrice;
                System.out.println("주문하신 상품의 총액은 " + totalPrice + "원 입니다.");
                System.out.println("결제하시겠습니까? 1.yes | 2.no");
                selectNo = sc.nextInt();
                if (selectNo == 1) {
                    System.out.println("결제에 성공하셨습니까? 1.yes | 2.no");
                    selectNo = sc.nextInt();
                    if (selectNo == 1) {
                        System.out.println("이용해주셔서 감사합니다.");
                        run = false;
                    } else if (selectNo == 2) {
                        System.out.println("결제에 실패하셨습니다.");
                    }
                }
            }
        }
    }
}
