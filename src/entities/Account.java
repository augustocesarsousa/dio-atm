package entities;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Account {

    private static Integer DEFAULT_NUMBER = 1;
    private static final DecimalFormatSymbols REAL = new DecimalFormatSymbols(new Locale("pt", "BR"));
    private DecimalFormat decimalFormat = new DecimalFormat("¤ ###,###,##0.00", REAL);

    private Integer number;
    private Integer agency;
    protected Double balance;
    private AccountHolder accountHolder;
    private Bank bank;

    public Account(Integer agency, AccountHolder accountHolder, Bank bank) {
        this.number = DEFAULT_NUMBER++;
        this.agency = agency;
        this.balance = 0d;
        this.accountHolder = accountHolder;
        this.bank = bank;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getAgency() {
        return agency;
    }

    public Double getBalance() {
        return balance;
    }

    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    public Bank getBank() {
        return bank;
    }

    public String showAccount() {
        return "Banco: " + this.bank.getName() + "\n" +
                "Número: " + this.number + "\n" +
                "Agência: " + this.agency + "\n" +
                "Títular: " + this.accountHolder.getName() + "\n" +
                "Saldo: " + decimalFormat.format(this.balance) + "\n";
    }

    public void deposit(Double value) {
        this.balance += value;
    }

    public boolean withdraw(Double value) {
        if (value <= this.balance) {
            this.balance -= value;
            return true;
        } else {
            return false;
        }
    }

    public void transference(Double value, Account account) {
        if (this.withdraw(value))
            account.deposit(value);
    }
}