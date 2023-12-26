package ch13_map.ex03;

import ch13_map.ex03.MemberDTO;

import java.util.Map;
import java.util.Scanner;

public class MemberService {
    Scanner sc = new Scanner(System.in);
    MemberRepository memberRepository = new MemberRepository();

    public void save() {
        boolean checkResult = false;
        String memberEmail = null;
        do {
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

    public static String loginEmail = null;
    public static String loginPassword = null;

    public void login() {
        if (loginEmail == null) {
            System.out.print("이메일 : ");
            String memberEmail = sc.next();
            System.out.print("비밀번호 : ");
            String memberPassword = sc.next();
            MemberDTO memberDTO = memberRepository.login(memberEmail, memberPassword);
            if (memberDTO != null) {
                // 조회결과 있음
                System.out.println("로그인 성공");
                loginEmail = memberEmail;
                loginPassword = memberPassword;
                System.out.println(loginEmail);
            } else {
                // 조회결과 없음
                System.out.println("로그인 실패");
            }
        } else {
            System.out.println("이미 로그인 되어있습니다. 로그인 되어있는 Email : " + loginEmail);
        }
    }

    public void findAll() {
        Map<Long, MemberDTO> memberDTOMap = memberRepository.findAll();
        System.out.println(memberDTOMap);
    }

    public void update() {
        if (loginEmail != null) {
            System.out.print("비밀번호를 입력하세요 : ");
            String memberPassword = sc.next();
            if (loginPassword.equals(memberPassword)) {
                System.out.print("바뀐 전화번호를 입력하세요 : ");
                String memberMobile = sc.next();
                boolean updateResult = memberRepository.update(loginEmail, memberMobile);
                if (updateResult) {
                    System.out.println("수정되었습니다.");
                } else {
                    System.out.println("수정 실패하였습니다.");
                }
            } else {
                System.out.println("비밀번호가 틀렸습니다.");

            }
        }
    }

    public void delete() {
        if (loginEmail != null) {
            System.out.println("진짜 탈퇴하실 건가요?");
            System.out.println("회원 탈퇴를 원하신다면 비밀번호를 입력하세요 : ");
            String memberPassword = sc.next();
            MemberDTO memberDTO = memberRepository.login(loginEmail, memberPassword);
            if (memberDTO != null) {
                boolean result = memberRepository.delete(loginEmail);
                if (result) {
                    System.out.println("회원 탈퇴 되었습니다.");
                } else {
                    System.out.println("탈퇴가 처리되지 않았습니다! 다시 시도해주세요.");
                }
            } else {
                System.out.println("비밀번호가 일치하지 않습니다! 메인메뉴로 돌아갑니다.");
            }
        } else {
            // 로그인이 되어 있지 않은 경우
            System.out.println("해당 기능은 로그인 후 사용 가능합니다.");
        }
    }

    public void logout() {
        loginEmail = null;
        System.out.println("로그아웃 되었습니다.");
    }
}
