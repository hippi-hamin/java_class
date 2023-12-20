package ch12_classes.ex05_bank;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        int selectNo = 0;
        BankService bankService = new BankService();

        while (run) {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("1.고객등록 | 2.잔액조회 | 3.입금 | 4.출금 | 5.거래내역확인 | 6.계좌이체 | 0.종료");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.print("선택> ");
            selectNo = sc.nextInt();
            sc.nextLine();
            if (selectNo == 1) {
                // 호출하는 문장 작성
                bankService.save();
            } else if (selectNo == 2) {
                // 호출하는 문장 작성
                bankService.balance();
            } else if (selectNo == 3) {
                // 호출하는 문장 작성
                bankService.deposit();
            } else if (selectNo == 4) {
                // 호출하는 문장 작성
                bankService.withdraw();
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
