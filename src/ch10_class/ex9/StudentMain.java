package ch10_class.ex9;

import java.io.PrintStream;

public class StudentMain {
    public static void main(String[] args) {
        // 객체선언문 - Student라는 클래스를 객체로 사용하기 위하여 선언(공식으로 봐도 무방)
        Student student = new Student();

        // 기본생성자로 Student 클래스 객체 만들고 setter를 이용하여 필드값 채우기
        student.setStudentName("하민");
        student.setStudentNumber(20202020);
        student.setStudentMajor("수학");
        student.setStudentMobile("010-3333-3333");

        // 모든 필드를 매개변수로 하는 생성자로 Student 클래스 객체 만들기
        Student student1 = new Student("하민", 20202020, "항해학", "010-1212-1212");
        System.out.println(student1);
        // 각각의 객체에서 print 메서드 호출하여 필드값 출력
        student.print();

        System.out.println("student1 = " + student);
    }
}
