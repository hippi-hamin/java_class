package ch10_class.ex9;

import org.w3c.dom.ls.LSOutput;

public class Student {
    /*
        필드
        이름(studentName)
        학번(studentNumber)
        학과(studentMajor)
        전화번호(studentMobile)
     */
    private String studentName;
    private int studentNumber;
    private String studentMajor;
    private String studentMobile;

    // 각 필드의 getter/setter 메서드

    // studentName setter
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    // studentName getter
    public String getStudentName() {
        return studentName;
    }
    // studentNumber setter
    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }
    // studentNumber getter
    public int getStudentNumber() {
        return studentNumber;
    }
    // studentMajor setter
    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }
    // studentMajor getter
    public String getStudentMajor() {
        return studentMajor;
    }
    // studentMobile setter
    public void setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
    }
    // studentMobile getter
    public String getStudentMobile() {
        return studentMobile;
    }

    // 기본생성자
    public Student(){
    }
    // 모든 필드를 매개변수로 하는 생성자
    public Student(String studentName, int studentNumber, String studentMajor, String studentMobile) {
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.studentMajor = studentMajor;
        this.studentMobile = studentMobile;
        // 호출하는 생성자를 만들어 주기 위해서 println() 메서드를 사용해주어야 함.
        System.out.println("studentName = " + studentName + ", studentNumber = " + studentNumber + ", studentMajor = " + studentMajor + ", studentMobile = " + studentMobile);
    }
    // 필드에 저장된 값을 출력하는 print() 메서드
    public void print(){
        System.out.println(getStudentName());
        System.out.println(getStudentNumber());
        System.out.println(getStudentMajor());
        System.out.println(getStudentMobile());
    }
}

