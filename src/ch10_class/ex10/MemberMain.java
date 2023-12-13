package ch10_class.ex10;

import java.util.Scanner;

public class MemberMain {
    public static void main(String[] args) {
        /**
         * 메뉴
         * 1. 회원가입(기본생성자이용)
         *      회원가입 정보는 스캐너로 받음.(next() 메서드 활용)
         * 2. 로그인
         * 3. 종료
         */
        Member mem = null;
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        int select = 0;

        while (run) {
            System.out.println("----------------------------------");
            System.out.println("1.회원가입 | 2.로그인 | 3. 종료");
            System.out.println("----------------------------------");
            System.out.print("무엇을 하시겠습니까? > ");
            select = sc.nextInt();
            if (select == 1) {
                mem = new Member();
                // String 대신 Scanner를 바로 받아도 좋음 (본인이 코드 이해했을 시)
                System.out.print("사용할 이메일을 입력하세요 : ");
                mem.setMemberEmail(sc.next());
                System.out.print("사용할 비밀번호를 입력하세요 : ");
                mem.setMemberPassword(sc.next());
                System.out.print("사용자의 이름을 입력하세요 : ");
                mem.setMemberName(sc.next());
                System.out.print("사용자의 전화번호를 입력하세요 : ");
                mem.setMemberMobile(sc.next());
                System.out.println("회원가입이 완료되었습니다.");

                // 코드 해석
//                System.out.println("이메일 : ");
//                String memberEmail = sc.next();
//                System.out.println("비번 : ");
//                String memberPassword = sc.next();
//                System.out.println("이름 : ");
//                String memberName = sc.next();
//                System.out.println("전번 : ");
//                String memberMobile = sc.next();
//                mem.setMemberEmail(memberEmail);
//                mem.setMemberPassword(memberPassword);
//                mem.setMemberName(memberName);
//                mem.setMemberMobile(memberMobile);

            } else if (select == 2) {
                System.out.println("이메일을 입력하세요 : ");
                String memberEmail = sc.next();
                System.out.println("비밀번호를 입력하세요 : ");
                String memberPassword = sc.next();
                boolean loginResult = mem.memberLogin(memberEmail, memberPassword);
                if(loginResult){
                    System.out.println("로그인 성공");
                } else {
                    System.out.println("로그인 실패");
                }
            } else if (select == 3){
                run = false;
            }
        }
    }
}
