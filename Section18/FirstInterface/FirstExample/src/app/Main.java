package app;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Enter with the rental data: ");
        System.out.println("Car model:");
        String carModel = sc.nextLine();
        System.out.println("Pick-up date (dd/MM/yyyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.println("Drop-off date (dd/MM/yyyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

        CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));

        System.out.println("Enter the price per hour: ");
        double pricePerHour = sc.nextDouble();
        System.out.println("Enter the price per day: ");
        double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
        rentalService.processInvoice(carRental);

        System.out.println("Invoice: ");
        System.out.println("Basic payment: $" + carRental.getInvoice().getBasicPayment());
        System.out.println("Tax: $" + carRental.getInvoice().getTax());
        System.out.println("Total payment: $" + carRental.getInvoice().getTotalPayment());

        sc.close();
    }
}