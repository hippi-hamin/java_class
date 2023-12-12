package ch10_class.ex7;

import ch10_class.ex6.MethodEx;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        /**
         * 실행하면 반복문으로 메뉴를 출력
         * 1.덧셈 2.뺄셈 3.곱셈 4.나눗셈
         * 각 번호를 선택하면 Calculator 클래스에 있는 해당 메시지 출력
         */
        Scanner sc = new Scanner(System.in);
        Calculator cal = new Calculator();
        boolean run = true;
        int select = 0, a = 0, b = 0;

        while (run) {
            System.out.println("1.덧셈 2.뺄셈 3.곱셈 4.나눗셈 5.종료");
            System.out.print("번호를 선택하세요 : ");
            select = sc.nextInt();
            if (select == 1) {
                System.out.print("두 개의 숫자를 입력하세요 : ");
                cal.sum(a = sc.nextInt(), b = sc.nextInt());
            } else if (select == 2) {
                System.out.println("두 개의 숫자를 입력하세요 : ");
                cal.sub(a = sc.nextInt(), b = sc.nextInt());
            } else if (select == 3) {
                System.out.println("두 개의 숫자를 입력하세요 : ");
                int mul = cal.mul(a = sc.nextInt(), b = sc.nextInt());
                System.out.println(mul);
            } else if (select == 4){
                System.out.println("두 개의 숫자를 입력하세요 : ");
                int result = cal.div();
                System.out.println(result);
            } else if (select == 5){
                run = false;
            }
        }
    }
}

