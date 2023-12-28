package chxx_project.service;

import chxx_project.common.CommonVariables;
import chxx_project.dto.CoffeeDTO;
import chxx_project.dto.DessertDTO;
import chxx_project.dto.MemberDTO;
import chxx_project.dto.TeaDTO;
import chxx_project.repository.MemberRepository;
import chxx_project.repository.MenuRepository;

import java.util.Scanner;

public class ManagerService {
    Scanner sc = new Scanner(System.in);
    MemberRepository memberRepository = new MemberRepository();
    MenuRepository menuRepository = new MenuRepository();

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
            System.out.print("이메일 : ");
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

    public void menuSave() {
        // 로그인 되어 있는 경우
        if (CommonVariables.loginEmail != null) {
            System.out.println("추가하고 싶은 메뉴의 카테고리를 입력하십시오.");
            System.out.println("1.커피 | 2.티 | 3.디저트");
            int selectNo = sc.nextInt();
            // 커피메뉴 등록
            if (selectNo == 1) {
                System.out.println("추가하실 커피의 정보를 입력하세요.");
                System.out.print("커피 이름 : ");
                String coffeeName = sc.next();
                System.out.print("가격 : ");
                int coffeePrice = sc.nextInt();
                System.out.print("카페인 : ");
                String coffeeCaffein = sc.next();
                System.out.print("열량 : ");
                String coffeeCalories = sc.next();
                System.out.print("탄수화물 : ");
                String coffeeCarbohydrate = sc.next();
                System.out.print("당류 : ");
                String coffeeSugars = sc.next();
                System.out.print("단백질 : ");
                String coffeeProtein = sc.next();
                System.out.print("나트륨 : ");
                String coffeeNatrium = sc.next();
                System.out.print("지방 : ");
                String coffeeFats = sc.next();

                CoffeeDTO coffeeDTO = new CoffeeDTO(coffeeName, coffeePrice, coffeeCaffein, coffeeCalories, coffeeCarbohydrate, coffeeSugars, coffeeProtein, coffeeNatrium, coffeeFats);
                boolean result = menuRepository.saveCoffee(coffeeDTO);

                if (result) {
                    System.out.println("메뉴가 성공적으로 등록되었습니다.");
                } else {
                    System.out.println("메뉴가 등록되지 않았습니다.");
                }
            // 차 메뉴 등록
            } else if (selectNo == 2) {
                System.out.println("추가하실 차의 정보를 입력하세요.");
                System.out.print("차 이름 : ");
                String teaName = sc.next();
                System.out.print("가격 : ");
                int teaPrice = sc.nextInt();
                System.out.print("열량 : ");
                String teaCalories = sc.next();
                System.out.print("탄수화물 : ");
                String teaCarbohydrate = sc.next();
                System.out.print("당류 : ");
                String teaSugars = sc.next();
                System.out.println("");
                System.out.print("단백질 : ");
                String teaProtein = sc.next();
                System.out.print("나트륨 : ");
                String teaNatrium = sc.next();
                System.out.print("지방 : ");
                String teaFats = sc.next();

                TeaDTO teaDTO = new TeaDTO(teaName, teaPrice, teaCalories, teaCarbohydrate, teaSugars, teaProtein, teaNatrium, teaFats);
                boolean result = menuRepository.saveTea(teaDTO);

                if (result) {
                    System.out.println("메뉴가 성공적으로 등록되었습니다.");
                } else {
                    System.out.println("메뉴가 등록되지 않았습니다.");
                }
            } else if (selectNo == 3) {
                System.out.println("추가하실 디저트의 정보를 입력하세요.");
                System.out.print("디저트 이름 : ");
                String dessertName = sc.next();
                System.out.print("가격 : ");
                int dessertPrice = sc.nextInt();
                System.out.print("열량 : ");
                String dessertCalories = sc.next();
                System.out.print("당류 : ");
                String dessertSugars = sc.next();
                System.out.print("단백질 : ");
                String dessertProtein = sc.next();
                System.out.print("나트륨 : ");
                String dessertNatrium = sc.next();
                System.out.print("지방 : ");
                String dessertFats = sc.next();

                DessertDTO dessertDTO = new DessertDTO(dessertName, dessertPrice, dessertCalories, dessertSugars, dessertProtein, dessertNatrium, dessertFats);
                boolean result = menuRepository.saveDessert(dessertDTO);

                if (result) {
                    System.out.println("메뉴가 성공적으로 등록되었습니다.");
                } else {
                    System.out.println("메뉴가 등록되지 않았습니다.");
                }
            }
            // 로그인 되어 있지 않은 경우
        } else {
            System.out.println("해당 기능은 관리자만 사용 가능합니다. 로그인 해주세요.");
        }
    }
}

