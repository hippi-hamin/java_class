package ch10_class.ex6;

import java.util.Arrays;

public class MethodExMain {
    public static void main(String[] args) {
        MethodEx methodEx = new MethodEx();
        System.out.println("호출 전");
        // method1 호출
        methodEx.method1();
        System.out.println("호출 후");

        // method2 호출
        methodEx.method2("안녕하세요");
        String str1 = "오늘은 화요일";
        methodEx.method2(str1);

        // method3 호출
        methodEx.method3();
        String result = methodEx.method3();
        System.out.println("result = " + result);

        // method4 호출 후 결과값 출력
        int result1 = methodEx.method4();
        System.out.println("result1 = " + result1);

        // method5의 호출문 '안녕 & 1000 = 입력값'
        String result2 = methodEx.method5("안녕", 1000);
        // method5의 실행문을 거쳐 나온 리턴값
        System.out.println("result2 = " + result2);

        int result3 = methodEx.method6(10, 20);
        System.out.println("result3 = " + result3);
    }
}
