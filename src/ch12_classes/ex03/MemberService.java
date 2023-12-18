package ch12_classes.ex03;

import ch12_classes.ex02.BookDTO;

import java.util.Scanner;

public class MemberService {
    Scanner sc = new Scanner(System.in);
    MemberRepository memberRepository = new MemberRepository();
    public void save() {
        System.out.print("이메일 : ");
        String memberEmail = sc.next();
        System.out.print("비밀번호 : ");
        String memberPassword = sc.next();
        System.out.print("이름 : ");
        String memberName = sc.next();
        System.out.print("전화번호 : ");
        String memberMobile = sc.next();
        // 나중엔 DTO클래스를 여러 개도 만들 수 있음.
        // 우리 member 이라는 클래스를 사용할 때 이 형식으로 사용할 것이라는 의미
        MemberDTO memberDTO = new MemberDTO(memberEmail, memberPassword, memberName, memberMobile);
        // memberRepository를 호출하면서 memberDTO를 넘겨주고, result로 받겠다.
        boolean result = memberRepository.save(memberDTO);

        if (result) {
            System.out.println("회원가입 성공");
        } else {
            System.out.println("회원가입 실패");
        }
    }
}
