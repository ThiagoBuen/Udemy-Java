package application;

import model.CurrencyConverter;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.println("What is the dollar price?");
        double dollarPrice = sc.nextDouble();
        System.out.println("How many dollars will be bought?");
        double dollarsToAcquire = sc.nextDouble();

        double priceToPay = CurrencyConverter.exchangeConverter(dollarPrice * dollarsToAcquire);
        System.out.println();
        System.out.printf("Current IOF Price: %.2f%n", CurrencyConverter.IOF);
        System.out.println();
        System.out.printf("Amount to be paid in reals: R$ %.2f%n", priceToPay);
        sc.close();
    }
}