package ch10_class.ex3;

public class StudentMain {
    public static void main(String[] args) {
        // 기본생성자로 객체 선언
        Student student1 = new Student();

        //  매개변수가 있는 생성자로 객체 선언
        Student student2 = new Student("이하민");
        // 어떤 생성자에 어떤 형식으로 입력했는지에 따라서 자동으로 실행

        // 매개변수 2개 있는 생성자로 객체 선언
        Student student3 = new Student("이름1", "체육학");

        // 매개변수 3개 있는 생성자로 객체 선언
        Student student4= new Student("이름2", "컴공", "010-3333-3333");
    }
}
