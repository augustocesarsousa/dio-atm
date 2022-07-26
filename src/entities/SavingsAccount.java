package entities;

public class SavingsAccount extends Account {

  private final Double INTEREST_FEE = 0.02;

  public SavingsAccount(
    Integer number,
    Integer agency,
    AccountHolder accountHolder,
    Bank bank
  ) {
    super(number, agency, accountHolder, bank);
  }

  // Sobrescreve o método depósito para adicionar a taxa de juros a cada depósito
  @Override
  public void deposit(Double value) {
    this.balance += value + (value * INTEREST_FEE);
  }
}
