package ch04_if;

import java.util.Scanner;

public class Ex03_IfExample {

	public static void main(String[] args) {
		/**
		 * 스캐너로 점수(score)를 하나 입력받아서
		 * 90점 이상이면 A
		 * 80점 이상이면 B
		 * 70점 이상이면 C
		 * 60점 이상이면 D
		 * 60점 보다 적은 점수면 F를 출력
		 */
		
		int score = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		score = scanner.nextInt();
		if(score >= 60) {
			System.out.println("D 입니다.");
		} else if (score >= 80) {
			System.out.println("B 입니다.");
		} else if (score >= 70) {
			System.out.println("C 입니다.");
		} else if (score >= 90) {
			System.out.println("A 입니다.");
		} else { 
			System.out.println("F 입니다.");		
		}

	}

}
