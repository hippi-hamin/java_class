package ch01_variables;

public class Ex01_variables {

	public static void main(String[] args) {
		// 본인의 이름(name), 나이(age), 키(height), 주소(address), 전화번호(mobile)
		// 를 입력할 수 있는 변수를 각각 선언해봅시다.
		// 변수 선언
		String name = "이하민";
		double age = 25.9;  //
		double height = 182.8;
		String address = "인천광역시 미추홀구 매소홀로 68, 203-1302";
		String mobile = "010-8432-1035";
		
	    // 변수값 출력 
		System.out.println(name);
		System.out.println("name");
//		System.out.println(name1);
		System.out.println("저의 이름은 : " + name);
		System.out.println("저의 이름은 : " + name + "입니다.");
		
	}

}
