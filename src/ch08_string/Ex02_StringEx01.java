package ch08_string;

import java.util.Scanner;

public class Ex02_StringEx01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        String ment = "";
        // 프로그램을 종료하는 키워드인 '종료'가 절대로 바뀌지 않을 경우
        final String QUIT = "종료";
        // final 키워드를 붙인 변수는 변수값을 바꿀 수 없음.
        // final에 지정하는 변수는 눈에 띄라고 전부 대문자로 설정하기도 함.
        // ANSWER = "다른값저장";  // Cannot assign a value to final variable 'ANSWER' 오류 뜸.

        System.out.println("메시지를 입력하세요.");
        System.out.println("프로그램을 종료하려면 '종료'를 입력하세요.");


        while(run){
            System.out.print(">");
            ment = sc.nextLine();     // next는
            System.out.println(ment);
            if(ment.equals(QUIT)){
                run = false;
            }
        }

    }
}

