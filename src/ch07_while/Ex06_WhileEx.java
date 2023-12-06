package ch07_while;

import java.util.Scanner;

public class Ex06_WhileEx {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = 0, count = 0;
        int avg = 0, sum = 0;
        boolean run = true;

        while (true) {
            System.out.println("정수를 입력하고 마지막에 0을 입력하세요 : ");
            while (run) {
                input = sc.nextInt();
                sum += input;
                if (input > 0) {
                    count++;
                } else if(input == 0){
                    run = false;
                }
                avg = sum / count;
            }
            System.out.println("입력한 숫자는 " + count + "개 입니다.");
            System.out.println("평균은 " + avg + "입니다.");
            run = true;
            count = 0;
            sum = 0;
        }
    }
}