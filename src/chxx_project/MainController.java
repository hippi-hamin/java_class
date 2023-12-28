package chxx_project;

import chxx_project.service.KioskService;
import chxx_project.service.ManagerService;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KioskService kioskService = new KioskService();
        ManagerService managerService = new ManagerService();
        boolean run = true;

        int selectNo = 0;
        while (run) {
            boolean run2 = true;
            System.out.println("====== 백곰카페 ======");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("1.All | 2.Coffee | 3.Tea | 4.Dessert | 5.Search | 6.basket | 7.Manager | 0.Quit");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.print("선택> ");
            selectNo = sc.nextInt();
            if (selectNo == 1) {
                System.out.println("====== 전체 메뉴 ======");
                kioskService.findAll();
            } else if (selectNo == 2) {
                System.out.println("====== Coffee ======");
                kioskService.coffeeAll();
            } else if (selectNo == 3) {
                System.out.println("====== Tea ======");
                kioskService.teaAll();
            } else if (selectNo == 4) {
                System.out.println("====== Dessert ======");
                kioskService.dessertAll();
            } else if (selectNo == 5) {
                System.out.println("====== Search ======");
                kioskService.search();
            } else if (selectNo == 6) {
                System.out.println("====== Basket ======");

            } else if (selectNo == 7) {
                System.out.println("관리자 메뉴");
                while (run2) {
                    System.out.println("====== 관리자 메뉴 ======");
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("1.로그인 | 2.메뉴추가 | 3.메뉴수정 | 4.메뉴삭제 | 5.로그아웃 | 6.회원가입 | 0.메인메뉴");
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.print("선택> ");
                    selectNo = sc.nextInt();
                    if (selectNo == 1) {
                        System.out.println("로그인");
                        managerService.login();
                    } else if (selectNo == 2) {
                        System.out.println("메뉴 추가");
                        managerService.menuSave();
                    } else if (selectNo == 3) {
                        System.out.println("메뉴 수정");
                        managerService.menuUpdate();
                    } else if (selectNo == 4) {
                        System.out.println("메뉴 삭제");
                        managerService.menuDelete();
                    } else if (selectNo == 5) {
                        System.out.println("로그아웃");
                        managerService.logout();
                    } else if (selectNo == 6) {
                        System.out.println("회원가입");
                        managerService.save();
                    } else if (selectNo == 0) {
                        System.out.println("메인 메뉴로 돌아갑니다.");
                        run2 = false;
                    }
                }
            } else if (selectNo == 0) {
                System.out.println("프로그램 종료");
                run = false;
            }
        }
    }
}
