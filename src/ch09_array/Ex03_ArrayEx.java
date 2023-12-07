package ch09_array;

import java.util.Scanner;

public class Ex03_ArrayEx {
    public static void main(String[] args) {
        /**
         * 크기가 3인 정수형 배열을 선언하고
         * 실행 했을 때 스캐너로 정수값을 입력 받아 배열에 저장
         * 배열에 저장된 값의 총합, 평균 계산
         */

        Scanner sc = new Scanner(System.in);
        int[] numbers1 = new int[3];
        int sum = 0;

        for(int i = 0; i < numbers1.length; i++){
            System.out.print("numbers1[" + i + "]의 값을 입력하시오 : ");
            numbers1[i] = sc.nextInt();
            sum += numbers1[i];
        }
        System.out.println("sum = " + sum);
        System.out.println("avg = " + sum / numbers1.length);
    }
}
