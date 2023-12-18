package ch12_classes.ex04;

import java.util.Scanner;

public class BoardMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        int selectNo = 0;
        BoardService boardService = new BoardService();

        while(run){
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("1.글작성 | 2.글목록 | 3.글조회 | 4.글수정 | 5.글삭제 | 6.검색 | 0.종료");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.print("선택> ");
            selectNo = sc.nextInt();
            if (selectNo == 1) {
                // 호출하는 문장 작성

            } else if (selectNo == 2) {
                // 호출하는 문장 작성

            } else if (selectNo == 3) {
                // 호출하는 문장 작성

            } else if (selectNo == 4) {
                // 호출하는 문장 작성

            } else if (selectNo == 5) {
                // 호출하는 문장 작성

            } else if (selectNo == 6) {
                // 호출하는 문장 작성

            } else if (selectNo == 0) {
                run = false;
            }
        }
    }
}
