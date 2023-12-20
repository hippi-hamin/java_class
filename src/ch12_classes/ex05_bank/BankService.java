package ch12_classes.ex05_bank;


import ch12_classes.ex03.MemberDTO;

import java.util.List;
import java.util.Scanner;

public class BankService {
    Scanner sc = new Scanner(System.in);
    BankRepository bankRepository = new BankRepository();

    public void save() {
        // 중복체크 결과를 담을 변수
        ClientDTO checkResult;
        String accountNumber = null;
        do {
            System.out.print("계좌번호 : ");
            accountNumber = sc.next();
            // checkResult가 true => 사용가능(반복문 종료), checkResult가 false => 사용불가(다시 이메일입력)
            checkResult = bankRepository.accountCheck(accountNumber);
            if (checkResult == null) {
                System.out.println("사용 가능한 계좌번호 입니다.");
            } else {
                System.out.println("이미 사용 중인 계좌번호 입니다.");
            }
        } while (checkResult != null); // checkResult 값이 false라면 계속 반복되도록
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

    ClientDTO clientDTO = new ClientDTO();

    public void balance() {
        System.out.println("계좌번호를 입력해주세요 : ");
        String accountNumber = sc.next();
        ClientDTO checkResult = bankRepository.accountCheck(accountNumber);
        if (checkResult != null) {
            if (checkResult.getBalance() == 0) {
                System.out.println("잔액이 없습니다.");
            } else {
                System.out.println(checkResult.getClientName() + "님의 현재 잔액은 " + checkResult.getBalance() + "원 입니다.");
            }
        } else {
            System.out.println("없는 계좌번호 입니다.");
        }
    }

    public void deposit() {
        System.out.println("계좌번호를 입력해주세요 : ");
        String accountNumber = sc.next();
        ClientDTO checkResult = bankRepository.accountCheck(accountNumber);
        if (checkResult != null) {
            System.out.print("입금하실 금액을 입력하세요 : ");
            long deposit = sc.nextLong();
            boolean depositResult = bankRepository.deposit(accountNumber, deposit);
            if (depositResult) {
                System.out.println("입급에 성공하였습니다.");
                System.out.println(checkResult.getClientName() + "님의 현재 잔액은 " + checkResult.getBalance() + "원 입니다.");
                // AccountDTO accountDTO = new AccountDTO(accountNumber, deposit, 0, );

            } else {
                System.out.println("입금에 실패하였습니다.");
            }
        } else {
            System.out.println("없는 계좌번호 입니다.");
        }
    }

    public void withdraw() {
        boolean run = true;
        System.out.println("계좌번호를 입력해주세요 : ");
        String accountNumber = sc.next();
        ClientDTO checkResult = bankRepository.accountCheck(accountNumber);
        if (checkResult != null) {
            while (run) {
                System.out.println("비밀번호를 입력하세요 : ");
                String clientPass = sc.next();
                boolean checkPass = bankRepository.checkPass(clientPass);
                if (checkPass) {
                    System.out.print("출금하실 금액을 입력하세요 : ");
                    long withdraw = sc.nextLong();
                    boolean withdrawResult = bankRepository.withdraw(accountNumber, withdraw);
                    if (withdrawResult) {
                        System.out.println("출금이 완료되었습니다.");
                        System.out.println("현재 잔액은 " + checkResult.getBalance() + "원 입니다.");
                        run = false;
                    } else {
                        System.out.println("잔액이 부족합니다.");
                        System.out.println(checkResult.getClientName() + "님의 현재 잔액은 " + checkResult.getBalance() + "원 입니다.");
                        run = false;
                    }
                } else {
                    System.out.println("비밀번호가 틀렸습니다.");
                }
            }
        } else {
            System.out.println("없는 계좌번호 입니다.");
        }
    }

    public void detail() {
        boolean run = true;

        System.out.println("-----------");
        System.out.println("계좌번호 입력");
        System.out.println("-----------");
        String accountNumber = sc.next();
        while (run) {
            ClientDTO accountNum1 = bankRepository.accountCheck(accountNumber);
            if (accountNum1 != null) {
                System.out.println("------------------------------------------------------");
                System.out.println("1. 전체 내역 조회 | 2. 입금 내역 조회 | 3. 출금 내역 조회 | 4. 종료");
                System.out.println("------------------------------------------------------");
                int selectNum = sc.nextInt();

                if (selectNum == 1) {
                    bankRepository.List(accountNumber);
                } else if (selectNum == 2) {
                    bankRepository.depositDetail(accountNumber);
                } else if (selectNum == 3) {
                    bankRepository.withDrawDetail(accountNumber);
                } else if (selectNum == 4) {
                    run = false;
                }
            }
        }
    }
}