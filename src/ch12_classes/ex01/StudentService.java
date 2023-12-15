package ch12_classes.ex01;

import java.util.List;
import java.util.Scanner;

public class StudentService {
    /**
     * method name : method1
     * parameter : x
     * return : x
     */
    // StudentRepository 클래스 객체 선언
    StudentRepository studentRepository = new StudentRepository();
    Scanner sc = new Scanner(System.in);

    public void method1() {
        System.out.println("StudentService.method1");
        // Repository의 method1을 호출
        studentRepository.method1();
    }

    public void method2() {
        System.out.println("StudentService.method2");
        String str1 = "집에 가고 싶다.";
        studentRepository.method2(str1);
    }

    /**
     * StudentDTO 객체를 생성하고
     * Repository의 method3로 DTO 객체를 전달함.
     */
    public void method3() {
        System.out.print("학생의 이름 : ");
        String name = sc.next();
        System.out.print("학생의 학번(숫자만 입력하세요) : ");
        int num = sc.nextInt();
        System.out.print("학생의 전공 : ");
        String Major = sc.next();
        System.out.print("학생의 전화번호 : ");
        String Mobile = sc.next();
        StudentDTO studentDTO = new StudentDTO(name, num, Major, Mobile);

        boolean result = studentRepository.method3(studentDTO);

        System.out.println("result = " + result);

        if (result) {
            System.out.println("학생등록 성공");
        } else {
            System.out.println("학생등록 실패");
        }
    }

    /**
     * Repository로 부터 List를 리턴 받아 for문으로 출력
     */
    public void method4() {
        List<StudentDTO> studentDTOList = studentRepository.method4();
        for (StudentDTO studentDTO : studentDTOList){
            System.out.println("studentDTO = " + studentDTO);
        }
    }
/**
 * 조회할 id를 입력 받고
 * id를 repository 로 전달 하고
 * repository 로 부터 id에 해당하는 학생정보를 리턴받고
 * 학생 정보를 출력
 */
public void method5() {
    System.out.println("조회할 id : ");
    Long id = sc.nextLong();
    StudentDTO studentDTO = studentRepository.method5(id);
    if(studentDTO != null){
        // 조회결과 있음
    System.out.println("studentDTO = " + studentDTO);
    } else {
        System.out.println("요청하신 정보를 찾을 수 없습니다.");
    }
}













}

