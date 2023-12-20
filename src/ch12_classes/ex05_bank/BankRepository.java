package ch12_classes.ex05_bank;

import ch12_classes.ex03.MemberDTO;

import java.util.ArrayList;
import java.util.List;

public class BankRepository {
    private static List<ClientDTO> clientDTOList = new ArrayList<>();

    public boolean save(ClientDTO clientDTO) {
        return clientDTOList.add(clientDTO);
    }

    public boolean accountCheck(String accountNumber) {
        boolean result = true;
        for (int i = 0; i < clientDTOList.size(); i++) {
            if (accountNumber.equals(clientDTOList.get(i).getAccountNumber())){
                // 중복되는 이메일이 있는 경우 => 결과를 false로 주기.
                result = false;
            }
        }
        return result;
    }

    public boolean balance(String accountNumber) {
        boolean result = false;
        for (int i = 0; i < clientDTOList.size(); i++) {
            if (accountNumber.equals(clientDTOList.get(i).getAccountNumber())){
                // Service에서 넘겨 받은 계좌가 리스트에 있는 경우
                result = true;
            }
        }
        return result;
    }
}
