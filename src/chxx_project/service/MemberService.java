package chxx_project.service;

import chxx_project.common.CommonVariables;
import chxx_project.dto.MemberDTO;
import chxx_project.repository.MemberRepository;

import java.util.Scanner;

public class MemberService {
    Scanner sc = new Scanner(System.in);
    MemberRepository memberRepository = new MemberRepository();

    public void save() {
        // 중복체크 결과를 담을 변수
        boolean checkResult = false;
        String memberEmail = null;
        do {
            System.out.println("회원가입 메뉴");
            System.out.print("사용할 이메일 : ");
            memberEmail = sc.next();
            // checkResult가 true => 사용가능(반복문 종료), checkResult가 false => 사용불가(다시 이메일입력)
            checkResult = memberRepository.emailCheck(memberEmail);
            if (checkResult) {
                System.out.println("사용 가능한 이메일 입니다.");
            } else {
                System.out.println("이미 사용 중인 이메일 입니다. 다른 이메일을 입력해주세요.");
            }
        } while (!checkResult); // checkResult 값이 false라면 계속 반복되도록
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

    public void login() {
        if (CommonVariables.loginEmail != null) {
            System.out.println("이미 로그인 되어있습니다.");
        } else {
            System.out.println("이메일 : ");
            String memberEmail = sc.next();
            System.out.print("비밀번호 : ");
            String memberPassword = sc.next();
            MemberDTO memberDTO = memberRepository.login(memberEmail, memberPassword);
            if (memberDTO != null) {
                // 조회결과 있음
                CommonVariables.loginEmail = memberEmail;
                System.out.println("로그인 성공");
                System.out.println(CommonVariables.loginEmail + "사장님 환영합니다!");
            } else {
                System.out.println("로그인 실패");
            }
        }
    }
}

