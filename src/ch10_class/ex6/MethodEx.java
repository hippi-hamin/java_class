package ch10_class.ex6;

public class MethodEx {
    // 매개변수 x, 리턴 x
    public void method1() {
        System.out.println("MethodEx.method1");
    }

    // 매개변수 o, 리턴 x
    public void method2(String param1){
        System.out.println("param1 = " + param1);
        String str2 = "집에 가고 싶다.";
        System.out.println(param1 + str2);
    }

    // 매개변수 x, 리턴 o
    // 리턴 String
    public String method3() {
        System.out.println("혹시");
        return "부르셨나요?";
    }

    // 리턴 int
    public int method4() {
        int num1 = 10;
        int num2 = 20;
        return num1 + num2;
    }

    // 매개변수 o, 리턴 o
    public String method5(String param1, int param2) {
        // 호출한 param1값과 param2값 확인 후 출력
        System.out.println("param1 = " + param1 + " param2 = " + param2);
        // method5의 실행문
        return "전달 받은 값은 " + param1 + "과 " + param2 + "입니다.";
    }

    public int method6(int num1, int num2) {
        return num1 + num2;
    }
}
