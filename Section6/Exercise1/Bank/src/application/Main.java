package application;

import model.BankAccount;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        BankAccount bankAccount;

        System.out.println("Enter account number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter account holder: ");
        String accountHolder = sc.nextLine();
        System.out.println("Is there an initial deposit (y/n)?");
        String initialDeposit = sc.nextLine();

        if(initialDeposit.equals("y")){
            System.out.println("Enter the initial deposit value: ");
            double initialDepositValue = sc.nextDouble();
            bankAccount = new BankAccount(accountNumber,accountHolder,initialDepositValue);
        }
        else {
            bankAccount = new BankAccount(accountNumber,accountHolder);
        }

        System.out.println();
        System.out.println(bankAccount);
        System.out.println();

        System.out.println("Enter a deposit value: ");
        double depositValue = sc.nextDouble();
        bankAccount.deposit(depositValue);

        System.out.println("Updated account data: ");
        System.out.println(bankAccount);
        System.out.println();

        System.out.println("Enter a withdraw value: ");
        double withdrawValue = sc.nextDouble();
        bankAccount.withdraw(withdrawValue);

        System.out.println("Updated account data: ");
        System.out.println(bankAccount);

        sc.close();

    }
}