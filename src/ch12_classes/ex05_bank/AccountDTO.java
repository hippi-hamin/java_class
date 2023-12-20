package ch12_classes.ex05_bank;

public class AccountDTO {
    ClientDTO clientDTO = new ClientDTO();
    // 필드
    Long id;
    String accountNumber;
    long deposit;
    long withdraw;
    String bankingAt;

    // getter/setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getDeposit() {
        return deposit;
    }

    public void setDeposit(long deposit) {
        this.deposit = deposit;
    }

    public long getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(long withdraw) {
        this.withdraw = withdraw;
    }

    public String getBankingAt() {
        return bankingAt;
    }

    public void setBankingAt(String bankingAt) {
        this.bankingAt = bankingAt;
    }

    // 기본생성자
    public AccountDTO(){}
    // 매개변수 갖는 생성자

    private static Long idvalue = 1L;
    public AccountDTO(Long id, String accountNumber, long deposit, long withdraw, String bankingAt) {
        this.id = idvalue++;
        this.accountNumber = accountNumber;
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.bankingAt = bankingAt;
    }
}
