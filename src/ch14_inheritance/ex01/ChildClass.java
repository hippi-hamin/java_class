package ch14_inheritance.ex01;

public class ChildClass extends ParentClass {
    public ChildClass() {
        System.out.println("자식 기본생성자");
    }

    // 메서드 재정의
    @Override  // 부모가 지정한 메서드 규칙을 잘 따르고 있는 지 컴파일 할 때 체크할 수 있도록 작성.
    public void hello() {
        System.out.println("ChildClass.hello");
    }
}
