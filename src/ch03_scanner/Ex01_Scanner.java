package ch03_scanner;

// java.util 패키지에 소속된 Scanner 클래스를 가져옴.
import java.util.Scanner;

public class Ex01_Scanner {

	public static void main(String[] args) {
		// scanner 라는 이름의 Scanner 클래스 객체 선언
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : "); //println()에서 ln의 의미는 ()를 출력하고 줄을 바꿈
		int num1 = scanner.nextInt();
		System.out.println(num1);
		
		System.out.print("이름을 입력하세요 : ");
	    String name = scanner.next();    // next는 문자 입력 가능
	    System.out.println(name);
	    
	    scanner.nextLine();
	    
		System.out.print("주소를 입력하세요 : ");
		String address = scanner.nextLine(); // nextLine은 긴 문장 입력 가능.
		System.out.println(address);
				
		
	}

}
