package ch04_if;

import java.util.Scanner;

public class Ex05_IfExample {

	public static void main(String[] args) {
		/**
		 * 정수 하나를 입력 받아서 양수, 음수, 0인지를 출력
		 */
		
		int num = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 정수로 입력하세요 : ");
		num = scanner.nextInt();		
		
		if (num >= 0) {
			if(num == 0) {
				System.out.println("0");
			}else {
				System.out.println("양수");
			}
		}else {
			System.out.println("음수");
		}
		
		
	}

}
