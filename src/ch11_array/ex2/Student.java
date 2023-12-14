package ch11_array.ex2;

public class Student {
    /**
     * 필드
     * 관리번호(id)
     * 이름(studentName)
     * 학번(studentNumber)
     * 학과(studentMajor)
     * 전화번호(studentMobile)
     *
     * getter/setter
     *
     * 생성자 2가지
     *
     * toString
     */

    // 필드
    private Long id ;
    private String studentName;
    private int studentNumber;
    private String studentMajor;
    private String studentMobile;

    // getter/setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    public String getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
    }

    // 기본생성자
    public Student(){

    }

    // 모든 필드를 매개변수로 갖는 생성자 - Overloading
    public Student(Long id, String studentName, int studentNumber, String studentMajor, String studentMobile) {
        this.id = id;
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.studentMajor = studentMajor;
        this.studentMobile = studentMobile;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentNumber=" + studentNumber +
                ", studentMajor='" + studentMajor + '\'' +
                ", studentMobile='" + studentMobile + '\'' +
                '}';
    }
}
