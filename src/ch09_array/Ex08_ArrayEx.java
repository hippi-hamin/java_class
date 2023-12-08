package ch09_array;

import java.util.Scanner;

public class Ex08_ArrayEx {
    public static void main(String[] args) {
        /**
         * 스캐너로 입력받은 숫자의 크기를 갖는 배열을 만들어 봅시다.
         * 예를 들어 5를 입력하면
         * 크기가 5인 배열이 만들어져야 함.
         */
        Scanner sc = new Scanner(System.in);

        int[] numbers = null;
        System.out.print("배열 크기 : ");
        int size = sc.nextInt();
        if (size > 0) {
            numbers = new int[size];
            System.out.println("numbers = " + numbers.length);
        } else {
            numbers = null;
        }
        System.out.println("numbers = " + numbers.length);


    }
}