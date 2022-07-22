package entities;

import java.util.List;

public class Bank {

    private Integer id;
    private String name;
    private List<Account> Account;

    public Bank(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account) {
        Account.add(account);
    }

    public List<Account> getAccount() {
        return Account;
    }
}