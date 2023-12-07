package ch07_while;

import java.util.Scanner;
public class Ex08_WhileEx {
    public static void main(String[] args) {
        /**
         *  1.예금 | 2.출금 | 3.잔고 | 4.종료
         *  ------------------------------------
         *  선택>1
         *  예금액>10000
         *  현재잔액은 10000입니다.
         *  ------------------------------------
         *  1.예금 | 2.출금 | 3.잔고 | 4.종료
         *  ------------------------------------
         *  선택> 2
         *  출금액>20,000
         *  잔고가 부족합니다.
         *  현재잔액은 10000입니다.
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("어서오세요 hm's 가계부의 오신 것을 환영합니다.");
        boolean run = true;
        int in = 0,      // 예금
            out = 0,     // 출금
            remain = 0,  // 잔액
            num = 0;     // 선택 번호

        while (run) {
            System.out.println("------------------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("------------------------------------");
            System.out.print("선택>");
            num = sc.nextInt();

            switch (num) {
                case 1: // num == 1
                    System.out.print("예금액>");
                    in = sc.nextInt();
                    remain += in;
                    System.out.println("현재 잔액은 " + remain + "원 입니다.");
                    break;
                case 2: // num == 2
                    System.out.print("출금액>");
                    out = sc.nextInt();
                    if(remain < out){
                        System.out.println("잔액이 부족합니다.");
                        System.out.println("현재 잔액은 " + remain + "원 입니다.");
                    } else {
                        remain -= out;
                        System.out.println("출금이 완료되었습니다.");
                        System.out.println("현재 잔액은 " + remain + "원 입니다.");
                    }
                    break;
                case 3: // num == 3
                    System.out.println("현재 잔액은 " + remain + "원 입니다.");
                    break;
                case 4: // num == 4
                    System.out.println("이용해주셔서 감사합니다. 가계부를 종료합니다.");
                    run = false;
                    break;
                default:
                    System.out.println("잘못 선택하셨습니다. 다시 입력해주십시오.");
                    break;
            }
        }
    }
}
