package ch12_classes.ex03;

import java.util.Scanner;

public class MemberMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        int selectNo = 0;
        MemberService memberService = new MemberService();

        while (run) {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("1.회원가입 | 2.로그인 | 3.회원목록 조회 | 4.회원정보 수정 | 5.회원탈퇴 | 6.로그아웃 | 7.이메일 중복체크 | 0.종료");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.print("선택> ");
            selectNo = sc.nextInt();
            if (selectNo == 1) {
                // 호출하는 문장 작성
                memberService.save();
            } else if (selectNo == 2) {
                // 호출하는 문장 작성
                memberService.login();
            } else if (selectNo == 3) {
                // 호출하는 문장 작성
                memberService.memberList();
            } else if (selectNo == 4) {
                // 호출하는 문장 작성
                memberService.update();
            } else if (selectNo == 5) {
                // 호출하는 문장 작성
                memberService.delete();
            } else if (selectNo == 6) {
                // 호출하는 문장 작성
                memberService.logout();
            } else if (selectNo == 7) {
                // 호출하는 문장 작성
                memberService.duplicate();
            }else if (selectNo == 0) {
                run = false;
            }
        }

    }
}
