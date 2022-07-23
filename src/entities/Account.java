package entities;

import utils.FormatMoney;

public class Account {

  private Integer number;
  private Integer agency;
  protected Double balance;
  private AccountHolder accountHolder;
  private Bank bank;

  public Account(
    Integer number,
    Integer agency,
    AccountHolder accountHolder,
    Bank bank
  ) {
    this.number = number;
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
    return (
      "Banco: " +
      this.bank.getName() +
      "\n" +
      "Conta: " +
      this.number +
      "\n" +
      "Agência: " +
      this.agency +
      "\n" +
      "Títular: " +
      this.accountHolder.getName() +
      "\n" +
      "Saldo: " +
      FormatMoney.format(this.balance) +
      "\n"
    );
  }

  public void deposit(Double value) {
    this.balance += value;
    System.out.println(
      "Operação realizada com sucesso! Saldo atualizado " +
      FormatMoney.format(this.balance) +
      "\n"
    );
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
    if (this.withdraw(value)) account.deposit(value);
  }
}
