package ch12_classes.ex06_memberboard.service;

import ch12_classes.ex06_memberboard.dto.MemberDTO;
import ch12_classes.ex06_memberboard.repository.MemberRepository;

import java.util.List;
import java.util.Scanner;

public class MemberService {
    Scanner sc = new Scanner(System.in);
    MemberRepository memberRepository = new MemberRepository();

    public void save() {
        // 중복체크 결과를 담을 변수
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
            System.out.println("로그인 실패");
        }
    }

    public void findAll() {
        List<MemberDTO> memberDTOList = memberRepository.findAll();
        for (MemberDTO memberDTO : memberDTOList) {
            System.out.println(memberDTO);
        }
    }

    public void update() {
        // 로그인 되어 있는 경우
        if (loginEmail != null) {
            boolean run = true;
            int selectNo = 0;
            while (run) {
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("1.비밀번호 | 2.이름 | 3.전화번호 | 0.종료");
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.print("선택> ");
                selectNo = sc.nextInt();
                if (selectNo == 1) {
                    System.out.print("현재 비밀번호를 입력하세요 : ");
                    String memberPassword = sc.next();
                    boolean passwordResult = memberRepository.passwordCheck(loginEmail, memberPassword);
                    if (passwordResult) {
                        System.out.print("변경할 비밀번호를 입력하세요 : ");
                        String updatePassword = sc.next();
                        boolean updateResult = memberRepository.updatePassword(loginEmail, updatePassword);
                        if (updateResult) {
                            System.out.println("비밀번호가 변경되었습니다.");
                            run = false;
                        } else {
                            System.out.println("비밀번호가 변경되지 않았습니다.");
                        }
                    } else {
                        System.out.println("비밀번호가 틀렸습니다. 다시 시도해주세요.");
                    }
                } else if (selectNo == 2) {
                    System.out.print("현재 비밀번호를 입력하세요 : ");
                    String memberPassword = sc.next();
                    boolean passwordResult = memberRepository.passwordCheck(loginEmail, memberPassword);
                    if (passwordResult) {
                        System.out.print("변경하실 이름을 입력해주세요 : ");
                        String updateName = sc.next();
                        boolean updateResult = memberRepository.updateName(loginEmail, updateName);
                        if (updateResult) {
                            System.out.println("이름이 변경되었습니다.");
                            run = false;
                        } else {
                            System.out.println("이름이 변경되지 않았습니다.");
                        }
                    } else {
                        System.out.println("비밀번호가 틀렸습니다. 다시 시도해주세요.");
                    }
                } else if (selectNo == 3) {
                    System.out.print("현재 비밀번호를 입력하세요 : ");
                    String memberPassword = sc.next();
                    boolean passwordResult = memberRepository.passwordCheck(loginEmail, memberPassword);
                    if (passwordResult) {
                        System.out.print("변경할 전화번호를 입력하세요 : ");
                        String updateMobile = sc.next();
                        boolean updateResult = memberRepository.updateMobile(loginEmail, updateMobile);
                        if (updateResult) {
                            System.out.println("전화번호가 변경되었습니다.");
                            run = false;
                        } else {
                            System.out.println("전화번호가 변경되지 않았습니다.");
                        }
                    } else {
                        System.out.println("비밀번호가 틀렸습니다. 다시 시도해주세요.");
                    }
                } else if (selectNo == 0) {
                    run = false;
                }
            }
        } else {
            System.out.println("해당 기능은 로그인 후 사용가능합니다.");
        }
    }
}

