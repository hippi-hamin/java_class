package ch12_classes.ex01;

import ch10_class.ex11.Board;

import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        int selectNo = 0;
        // StudentService 클래스 객체 선언
        StudentService studentService = new StudentService();

        while (run) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("1.테스트 | 2.테스트 | 3.학생 정보 등록 | 4.학생 정보 전체 확인 | 5.id로 학생 정보 확인 | 0.종료");
            System.out.println("--------------------------------------------------------------");
            System.out.print("선택> ");
            selectNo = sc.nextInt();
            if (selectNo == 1) {
                System.out.println("메서드 호출 전");
                studentService.method1();
                System.out.println("메서드 호출 후");
            } else if (selectNo == 2) {
                studentService.method2();
            } else if (selectNo == 3) {
                studentService.method3();
            } else if (selectNo == 4) {
                studentService.method4();
            } else if (selectNo == 5) {
                studentService.method5();
            } else if (selectNo == 0) {
                run = false;
            }

        }
    }

}
