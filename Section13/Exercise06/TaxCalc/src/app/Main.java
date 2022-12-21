package app;

import model.Business;
import model.Citizen;
import model.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> taxForms = new ArrayList<>();

        System.out.println("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax Payer #" + i + " data: ");
            System.out.print("Individual or company (i/c)? ");
            char outsourcedOption = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String payerName =  sc.next();
            System.out.print("Annual Income: ");
            double annualIncome = sc.nextDouble();

            if (outsourcedOption == 'i') {
                System.out.print("Health Expenditures: ");
                double healthExpenditure = sc.nextDouble();
                Citizen citizen = new Citizen(payerName, annualIncome, healthExpenditure);
                taxForms.add(citizen);
            } else {
                System.out.print("Number of employees: ");
                int employeesNumber = sc.nextInt();
                Business business = new Business(payerName, annualIncome, employeesNumber);
                taxForms.add(business);
            }
        }

        System.out.println("TAXES PAID");
        for (TaxPayer tax : taxForms) {
            System.out.println(tax.getName() + " - $" + String.format("%.2f", tax.calculateTax()));
        }
        System.out.println("Total tax: $" + String.format("%.2f", taxForms.stream()
                                                                          .mapToDouble(TaxPayer::calculateTax)
                                                                          .sum()) );
        sc.close();
    }
}