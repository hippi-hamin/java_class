package ch12_classes.ex05_bank;

import ch12_classes.ex03.MemberDTO;

import java.util.ArrayList;
import java.util.List;

public class BankRepository {
    private static List<ClientDTO> clientDTOList = new ArrayList<>();
    private static List<AccountDTO> accountDTOList = new ArrayList<>();

    public boolean save(ClientDTO clientDTO) {
        return clientDTOList.add(clientDTO);
    }

    public ClientDTO accountCheck(String accountNumber) {
        ClientDTO result = null;
        for (int i = 0; i < clientDTOList.size(); i++) {
            if (accountNumber.equals(clientDTOList.get(i).getAccountNumber())) {
                // 중복되는 이메일이 있는 경우 => 결과를 false로 주기.
                result = clientDTOList.get(i);
                return result;
            }
        }
        return null;
    }

    public boolean checkPass(String clientPass) {
        boolean result = false;
        for (int i = 0; i < clientDTOList.size(); i++) {
            if (clientPass.equals(clientDTOList.get(i).getClientPass())) {
                // Service에서 넘겨 받은 계좌가 리스트에 있는 경우
                result = true;
            }
        }
        return result;
    }


    public boolean deposit(String accountNumber, long deposit) {
        boolean result = false;
        for (int i = 0; i < clientDTOList.size(); i++) {
            // clientDTOList.get(i) 인덱스에서 accountNumber와 같은 accountNumber 정보를 찾는 문장
            if (accountNumber.equals(clientDTOList.get(i).getAccountNumber())) {
                // clientDTOList.get(i) = 해당 인덱스에 접근 하여
                //  = 해당 데이터에 member 값을 수정.
                long result1 = clientDTOList.get(i).getBalance();
                result1 = result1 + deposit;
                clientDTOList.get(i).setBalance(result1);
                result = true;
            }
        }
        return result;
    }


    public boolean withdraw(String accountNumber, long withdraw) {
        boolean result = false;
        for (int i = 0; i < clientDTOList.size(); i++) {
            // clientDTOList.get(i) 인덱스에서 accountNumber과 같은 accountNumber 정보를 찾는 문장
            if (accountNumber.equals(clientDTOList.get(i).getAccountNumber())) {
                if (withdraw <= clientDTOList.get(i).getBalance()) {
                    // clientDTOList.get(i) = 해당 인덱스에 접근 하여
                    // setBalance(getsetMemberMobile(memberMobile) = 해당 데이터에 member 값을 수정.
                    clientDTOList.get(i).setBalance(clientDTOList.get(i).getBalance() - withdraw);
                    result = true;
                } else {
                    result = false;
                }
            }
        }
        return result;
    }
}
