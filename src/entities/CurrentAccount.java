package entities;

public class CurrentAccount extends Account {

  private final Double WITHDRAW_FEE = 5d;
  // Adicionado cheque especial
  private final Double OVERDRAFT = 500d;

  public CurrentAccount(
    Integer number,
    Integer agency,
    AccountHolder accountHolder,
    Bank bank
  ) {
    super(number, agency, accountHolder, bank);
  }

  // Sobrescreve o método saque para cobrar a taxa por cada saque
  @Override
  public boolean withdraw(Double value) {
    if ((value + WITHDRAW_FEE) <= (this.balance + OVERDRAFT)) {
      this.balance -= (value + WITHDRAW_FEE);
      return true;
    } else {
      return false;
    }
  }
}
