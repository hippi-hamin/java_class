package ch02_operator;

public class Ex04_LogicalOperator {

	public static void main(String[] args) {
		// 논리연산자
		System.out.println(true && true);
		System.out.println(true && false); // false
		System.out.println(true || true);
		
		boolean bool1 = true;
		boolean bool2 = false;
		boolean bool3 = true;
		
		System.out.println(bool1 && bool2);
		// bool2, bool3의 OR 연산 결과를 result 라는 변수에 담고 result 변수값 출력
		
        boolean result = bool2 || bool3;
        System.out.println(result);
        
        /* num1, num2 정수형 변수에 각각 10, 20을 대입하여 선언하고
         * num1 > num2 결과를 result1 에 저장하고
         * num1 != num2 결과를 result2 에 저장해서
         * result1 && result2 결과를 result3에 저장한 뒤
         * result3의 값을 출력         
         */
        
        int num1 = 10, num2 = 20;
        boolean result1 = num1 > num2;  // false
        boolean result2 = num1 != num2; // true
        boolean result3 = result1 && result2; // false
        
        System.out.println(result3);
        
        boolean result4 = (num1 > num2) && (num1 != num2);
        System.out.println(result4);
        
        System.out.println(bool1);   // true
        System.out.println(!bool1);  // false
        System.out.println(bool1 && bool2);    // false
        System.out.println(!(bool1 && bool2)); // true
        
        System.out.println("Not 연산 수행 전 : " + bool2);
        bool2 = !bool2;
        System.out.println("Not 연산 수행 후 : " + bool2);
        
                
	}

}
