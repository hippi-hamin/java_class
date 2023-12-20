package ch12_classes.ex05_bank;


import ch12_classes.ex03.MemberDTO;

import java.util.List;
import java.util.Scanner;

public class BankService {
    Scanner sc = new Scanner(System.in);
    BankRepository bankRepository = new BankRepository();

    public void save() {
        // 중복체크 결과를 담을 변수
        boolean checkResult = false;
        String accountNumber = null;
        do {
            System.out.print("계좌번호 : ");
            accountNumber = sc.next();
            // checkResult가 true => 사용가능(반복문 종료), checkResult가 false => 사용불가(다시 이메일입력)
            checkResult = bankRepository.accountCheck(accountNumber);
            if (checkResult) {
                System.out.println("사용 가능한 계좌번호 입니다.");
            } else {
                System.out.println("이미 사용 중인 계좌번호 입니다.");
            }
        } while (!checkResult); // checkResult 값이 false라면 계속 반복되도록
        System.out.print("비밀번호 : ");
        String clientPass = sc.next();
        System.out.print("이름 : ");
        String clientName = sc.next();
        long balance = 0;
        // 우리 Account 라는 클래스를 사용할 때 이 형식으로 사용할 것이라는 의미
        ClientDTO clientDTO = new ClientDTO(clientName, accountNumber, clientPass, balance);
        // bankRepository를 호출하면서 clientDTO를 넘겨주고, result로 받겠다.
        boolean result = bankRepository.save(clientDTO);

        if (result) {
            System.out.println("고객등록 성공");
        } else {
            System.out.println("고객등록 실패");
        }

    }

    public void balance() {
        ClientDTO clientDTO = null;
        System.out.println("계좌번호를 입력해주세요 : ");
        String accountNumber = sc.next();
        boolean checkResult = bankRepository.balance(accountNumber);
        if (checkResult) {
            if (clientDTO.getBalance() == 0) {
                System.out.println("잔액이 없습니다.");
            } else {
                System.out.println(clientDTO.getBalance());
            }
        } else {
            System.out.println("없는 계좌번호입니다.");
        }
    }
}