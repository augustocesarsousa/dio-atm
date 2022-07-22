package entities;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private static Integer DEFAULT_NUMBER = 1;

    private Integer id;
    private String name;
    private List<Account> accounts = new ArrayList<>();

    public Bank(String name) {
        this.id = DEFAULT_NUMBER++;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public List<Account> getAccount() {
        return accounts;
    }
}