import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Account;
import entities.AccountHolder;
import entities.Bank;
import entities.CurrentAccount;
import entities.SavingsAccount;
import utils.FormatMoney;

public class App {

  static Scanner scanner = new Scanner(System.in);
  static List<Bank> banks = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    AccountHolder accountHolder1 = new AccountHolder(
      "Sushi Sousa",
      "12345678910"
    );
    AccountHolder accountHolder2 = new AccountHolder(
      "Zeus Oliveira",
      "98765432110"
    );

    Bank bank1 = new Bank("Santander");
    Bank bank2 = new Bank("DIO Pay");

    Account account1 = new SavingsAccount(1, 2, accountHolder1, bank1);
    Account account2 = new CurrentAccount(3, 4, accountHolder2, bank2);

    account1.deposit(100d);
    account2.deposit(100d);

    bank1.addAccount(account1);
    bank2.addAccount(account2);

    banks.add(bank1);
    banks.add(bank2);

    System.out.println("\nBem vindo ao Caixa Eletrônico da DIO!\n");

    Bank bankSelected = selectBank(banks);
    Account accountSelect = selectAccount(bankSelected);
    makeOperations(accountSelect);

    scanner.close();
  }

  private static Bank selectBank(List<Bank> banks) {
    Integer bankId;
    Bank bankSelected = null;
    boolean bankOption = true;

    while (bankOption) {
      System.out.println("Selecione seu banco para iniciarmos uma operação:\n");
      System.err.println("------------------------------------------------\n");
      for (Bank bank : banks) {
        System.out.println(bank.getId() + " - para " + bank.getName());
      }
      System.out.println("0 - para Finalizar\n");

      System.out.print("Opção: ");
      bankId = scanner.nextInt();
      System.err.println("\n------------------------------------------------");

      switch (bankId) {
        case 0:
          exit();
        case 1:
          bankSelected = banks.get(0);
          bankOption = false;
          break;
        case 2:
          bankSelected = banks.get(1);
          bankOption = false;
          break;
        default:
          System.out.println("Esta opção não existe!\n");
          break;
      }
    }
    return bankSelected;
  }

  private static Account selectAccount(Bank bank) {
    boolean findAccount = true;
    Account account = null;

    System.out.println("\nBem vindo ao " + bank.getName() + "!\n");

    while (findAccount) {
      System.out.println("Informe os dados da sua conta abaixo:\n");

      System.out.print("Conta: ");
      Integer accountNumber = scanner.nextInt();

      System.out.print("Agência: ");
      Integer accountAgency = scanner.nextInt();

      System.out.println("");

      for (Account acc : bank.getAccount()) {
        if (
          accountAgency == acc.getAgency() && accountNumber == acc.getNumber()
        ) account = acc;
      }

      if (account == null) {
        System.err.println(
          "------------------------------------------------\n"
        );
        System.out.println(
          "Conta não encontrada, gostaria de refazer a busca?\n"
        );
        System.out.println("1 - para SIM");
        System.out.println("2 - para NÃO\n");
        System.out.printf("Opção: ");
        int option = scanner.nextInt();
        System.out.println("");
        if (option != 1) exit();
      } else {
        findAccount = false;
      }
    }

    return account;
  }

  private static void makeOperations(Account account) {
    int option;

    System.out.println("Olá " + account.getAccountHolder().getName() + "!\n");
    System.out.println("Selecione a operação que deseja realizar!\n");

    System.out.println("1 - para Depósito");
    System.out.println("2 - para Saldo");
    System.out.println("3 - para Saque");
    System.out.println("4 - para Transferência");
    System.out.println("0 - para Finalizar\n");
    System.out.print("Opção: ");
    option = scanner.nextInt();
    System.out.println("");

    switch (option) {
      case 0:
        exit();
        break;
      case 1:
        makeDeposit(account);
        break;
      case 2:
        getBalance(account);
        break;
      default:
        break;
    }
  }

  private static void makeDeposit(Account account) {
    Double value;

    System.out.println("------ Depósito ------\n");
    System.out.print("Digite o valor do depósito: ");
    value = scanner.nextDouble();
    account.deposit(value);

    makeOtherOperation(account);
  }

  private static void getBalance(Account account) {
    System.out.println(
      "Saldo atual " + FormatMoney.format(account.getBalance()) + "\n"
    );

    makeOtherOperation(account);
  }

  private static void makeOtherOperation(Account account) {
    System.out.println("Deseja realizar outra operação?\n");
    System.out.println("1 - para SIM");
    System.out.println("2 - para NÃO\n");
    System.out.printf("Opção: ");
    int option = scanner.nextInt();
    System.out.println("");
    if (option != 1) {
      exit();
    } else {
      makeOperations(account);
    }
  }

  private static void exit() {
    System.out.println("Obrigado por utilizar nossos serviços!");
    System.exit(0);
  }
}
