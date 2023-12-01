package ch03_scanner;

import java.util.Scanner;

public class Ex02_Calculator {

	public static void main(String[] args) {
		/**
		 * 정수 2개를 각각 스캐너로 num1, num2에 입력 받아서 입력 받은 수의 합을 출력하세요.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 숫자를 입력하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 숫자를 입력하세요 : ");
		int num2 = sc.nextInt();
		int sum = num1 + num2;
		System.out.println("합계 : " + sum);
		System.out.println(num1 + "과 " + num2 + "의 합계는 " + sum + "입니다.");
		System.out.println(num1 + " + " + num2 + " = " + sum);
			
		
	}

}
