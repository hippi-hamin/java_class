package ch12_classes.ex03;

import ch12_classes.ex02.BookDTO;

import java.util.List;
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

    private static String loginEmail = null;

    public void login() {
        System.out.print("이메일 : ");
        String memberEmail = sc.next();
        System.out.print("비밀번호 : ");
        String memberPassword = sc.next();
        MemberDTO memberDTO = memberRepository.login(memberEmail, memberPassword);
        if (memberDTO != null) {
            // 조회결과 있음
            System.out.println("로그인 성공");
            loginEmail = memberEmail;
        } else {
            // 조회결과 없음
            System.out.println("로그인 실패");
        }
    }

    public void memberList() {
        List<MemberDTO> memberDTOList = memberRepository.memberList();
        for (MemberDTO memberDTO : memberDTOList) {
            System.out.println(memberDTO);
        }
    }

    public void update() {
        // 로그인 되어 있는 경우
        if (loginEmail != null) {
            // 조회결과 있음
            System.out.print("수정할 전화번호를 입력하세요 : ");
            String memberMobile = sc.next();
            boolean updateResult = memberRepository.update(loginEmail, memberMobile);

            if (updateResult) {
                System.out.println("수정되었습니다.");
            } else {
                System.out.println("수정 실패하였습니다.");
            }
        } else {
            // 로그인이 되어 있지 않은 경우
            System.out.println("해당 기능은 로그인 후 사용 가능합니다.");
        }
    }

    public void delete() {
        if (loginEmail != null) {
            System.out.println("회원 탈퇴를 원하신다면 비밀번호를 입력하세요 : ");
            String memberPassword = sc.next();
            boolean result = memberRepository.delete(loginEmail, memberPassword);
            if (result) {
                System.out.println("회원 탈퇴 되었습니다.");
            } else {
                System.out.println("비밀번호가 틀렸습니다.");
            }
        } else {
            // 로그인이 되어 있지 않은 경우
            System.out.println("해당 기능은 로그인 후 사용 가능합니다.");
        }
    }

    public void logout() {
        if (loginEmail != null) {
            loginEmail = null;
            System.out.println("로그아웃 되었습니다.");
        } else {
            System.out.println("해당 기능은 로그인 후 사용 가능합니다.");
        }
    }

    public void duplicate() {
        boolean run = true;
        while (run) {
            System.out.print("사용할 이메일 : ");
            String memberEmail = sc.next();
            MemberDTO memberDTO = memberRepository.duplicate(memberEmail);
            if (memberDTO != null) {
                // 조회결과 있음
                System.out.println("중복된 이메일입니다.");
            } else {
                // 조회결과 없음
                System.out.println("사용 가능한 이메일입니다.");
                System.out.print("사용할 비밀번호 : ");
                String memberPassword = sc.next();
                System.out.print("이름 : ");
                String memberName = sc.next();
                System.out.print("전화번호 : ");
                String memberMobile = sc.next();
                // 나중엔 DTO클래스를 여러 개도 만들 수 있음.
                // 우리 member 이라는 클래스를 사용할 때 이 형식으로 사용할 것이라는 의미
                MemberDTO memberDTO1 = new MemberDTO(memberEmail, memberPassword, memberName, memberMobile);
                // memberRepository를 호출하면서 memberDTO를 넘겨주고, result로 받겠다.
                boolean result = memberRepository.save(memberDTO1);

                if (result) {
                    System.out.println("회원가입 성공");
                } else {
                    System.out.println("회원가입 실패");
                }
                run = false;
            }
        }
    }
}
