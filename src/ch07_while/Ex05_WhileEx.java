package ch07_while;

import java.util.Scanner;
public class Ex05_WhileEx {
    public static void main(String[] args) {
        /**
         * random() 메서드를 이용해서 1~100 사이의 숫자를 하나 만들고
         * 반복문 안에서 해당 숫자를 맞출 때까지 계속 숫자를 입력 받도록 하고
         * 숫자를 맞추면 종료하고 몇 번만에 맞췄는 지를 출력해줌
         */

        Scanner sc = new Scanner(System.in);
        int input = 0, count = 0;
        boolean run = true;
        System.out.println("up & down");
        int answer = (int) (Math.random() * 100) + 1;

        while (run) {
            System.out.print("숫자를 입력하세요 : ");
            input = sc.nextInt();
            count++;
            if(input > answer){
                System.out.println("Down");
            } else if (answer > input){
                System.out.println("Up");
            } else {
                System.out.println("정답입니다.");
                System.out.println("시도 횟수는 " + count + "회 입니다.");
                run = false;
            }
        }
    }
}
