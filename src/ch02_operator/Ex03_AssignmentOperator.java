package ch02_operator;

public class Ex03_AssignmentOperator {

	public static void main(String[] args) {
		int num1 = 10, num2 = 7;
		System.out.println("num1 : " + num1 + "num2 : " + num2);
		//대입연산자 활용
		num1 += num2; //num1 = num1 +num2;
		System.out.println("num1 : "+num1+" num2 : "+num2);
		num1 += num2;
		System.out.println("num1 : "+num1+" num2 : "+num2);
		num1 -= num2; // num1 = 17; num2 = 7
		System.out.println("num1 : "+num1+" num2 : "+num2);
		num1 *= num2;// num1 = 119; num2 = 7
		System.out.println("num1 : "+num1+" num2 : "+num2);
		num1 /= num2;// num1 = 17 num2 = 7
		System.out.println("num1 : "+num1+" num2 : "+num2);
		// 별다른 메서드 내용이 없으면 계속 누적되어 계산
	}

}
