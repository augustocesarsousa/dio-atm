import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Account;
import entities.AccountHolder;
import entities.Bank;
import entities.CurrentAccount;
import entities.SavingsAccount;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static List<Bank> banks = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        AccountHolder accountHolder1 = new AccountHolder("Sushi Sousa", "12345678910");
        AccountHolder accountHolder2 = new AccountHolder("Zeus Oliveira", "98765432110");

        Bank bank1 = new Bank("Santander");
        Bank bank2 = new Bank("DIO Pay");

        Account account1 = new SavingsAccount(101, accountHolder1, bank1);
        Account account2 = new CurrentAccount(103, accountHolder2, bank2);

        account1.deposit(100d);
        account2.deposit(100d);

        bank1.addAccount(account1);
        bank2.addAccount(account2);

        banks.add(bank1);
        banks.add(bank2);

        selectBankMenu(banks);
    }

    private static void selectBankMenu(List<Bank> banks) {
        Integer bankId;
        boolean bankOption = true;

        System.out.println("");
        System.out.println("Bem vindo ao Caixa Eletrônico da DIO!");
        System.out.println("");
        System.out.println("Selecione seu banco para iniciarmos uma operação.");
        System.out.println("");
        System.err.println("-----------------------------------");
        System.out.println("");
        for (Bank bank : banks) {
            System.out.println(bank.getId() + " - para " + bank.getName());
        }
        ;
        System.out.println("0 - para finalizar");

        while (bankOption) {
            System.out.print("Opção: ");
            bankId = scanner.nextInt();

            switch (bankId) {
                case 0:
                    System.out.println("");
                    System.out.println("Obrigado por utilizar nossos serviços!");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("");
                    System.out.println("Santander");
                    bankOption = false;
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("DIO Play");
                    bankOption = false;
                    break;
                default:
                    System.out.println("");
                    System.out.println("Esta opção não existe!");
                    break;
            }
        }
    }
}
