package ch12_classes.ex06_memberboard;

import ch12_classes.ex06_memberboard.service.BoardService;
import ch12_classes.ex06_memberboard.service.MemberService;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberService memberService = new MemberService();
        BoardService boardService = new BoardService();
        boolean run = true;

        int selectNo = 0;
        while (run) {
            boolean run2 = true;
            System.out.println("====== 회원관리 ======");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("1.회원가입 | 2.로그인 | 3.회원목록 | 4.회원수정 | 5.회원탈퇴 | 6.로그아웃 | 7.게시판메뉴 | 0.종료");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.print("선택> ");
            selectNo = sc.nextInt();
            if (selectNo == 1) {
                memberService.save();
            } else if (selectNo == 2) {
                memberService.login();
            } else if (selectNo == 3) {
                memberService.findAll();
            } else if (selectNo == 4) {
                memberService.update();
            } else if (selectNo == 5) {
                memberService.delete();
            } else if (selectNo == 6) {
                memberService.logout();
            } else if (selectNo == 7) {
                if (memberService.loginResult()) {
                    while (run2) {
                        System.out.println("====== 게시판 ======");
                        System.out.println("-----------------------------------------------------------------------------------------");
                        System.out.println("1.글작성 | 2.글목록 | 3.글조회 | 4.글수정 | 5.글삭제 | 6.검색 | 99.sample | 0.메인메뉴");
                        System.out.println("-----------------------------------------------------------------------------------------");
                        System.out.print("선택> ");
                        selectNo = sc.nextInt();
                        sc.nextLine();
                        if (selectNo == 1) {
                            boardService.save();
                        } else if (selectNo == 2) {
                            boardService.findAll();
                        } else if (selectNo == 3) {
                            boardService.findById();
                        } else if (selectNo == 4) {
                            boardService.update();
                        } else if (selectNo == 5) {

                        } else if (selectNo == 6) {

                        } else if (selectNo == 99) {

                        } else if (selectNo == 0) {
                            System.out.println("메인 메뉴로 돌아갑니다.");
                            run2 = false;
                        }
                    }
                } else {
                    System.out.println("회원 전용 메뉴입니다.");
                }
            } else if (selectNo == 0) {
                System.out.println("종료");
                run = false;
            }
        }
    }
}