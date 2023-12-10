package ch09_array;

import java.util.Scanner;

public class Ex06_ArrayEx {
    public static void main(String[] args) {
        /**
         * 크기가 5인 정수형 배열을 선언하고
         * 스캐너로 배열에 값을 저장한 뒤
         * 입력된 값 중에서 가장 큰 값을 출력
         */
        int[] numbers = new int[5];
        Scanner sc = new Scanner(System.in);
        int max = 0;
        System.out.println("숫자를 입력하세요 : ");
        for (int i = 0; i < numbers.length; i++) {
            //  배열에 값 저장
            numbers[i] = sc.nextInt();
            //  입력 값 중 최댓값 구하기
            if(numbers[i] > max){      //  처음 max = 입력값
                max = numbers[i];      //  다음 max와 입력값 비교 후 입력값이 더 크면
                                       //  max는 입력값 그렇지 않은 경우는 기존 max값 그대로
            }
        }
        System.out.println("가장 큰 숫자는 " + max + "입니다.");
    }
}
