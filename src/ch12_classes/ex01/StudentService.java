package ch12_classes.ex01;

public class StudentService {
    /**
     * method name : method1
     * parameter : x
     * return : x
     */
    // StudentRepository 클래스 객체 선언
    StudentRepository studentRepository = new StudentRepository();
    public void method1(){
        System.out.println("StudentService.method1");
        // Repository의 method1을 호출
        studentRepository.method1();
    }
    public void method2(){
        System.out.println("StudentService.method2");
        String str1 = "집에 가고 싶다.";
        studentRepository.method2(str1);
    }
    public void method3(){
        System.out.println("StudentService.method3");
    }

}
