package App;

import model.entities.Contract;
import model.entities.Installment;
import model.services.PaymentService;
import model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        System.out.println("Enter the contract number: ");
        int contractNumber = sc.nextInt();
        System.out.print("Enter the contract date (dd/MM/yyyy): ");
        LocalDate contractDate = LocalDate.parse(sc.next(), fmt);
        System.out.print("Enter the contract value: ");
        double totalValue = sc.nextDouble();
        System.out.print("Enter the number of the desired installments: ");
        int months = sc.nextInt();

        Contract contract = new Contract(contractNumber, contractDate, totalValue);

        PaymentService paymentService = new PaymentService(new PaypalService());
        paymentService.processContract(contract, months);

        System.out.println("Installments: ");

        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment.toString());
        }

        sc.close();
    }
}