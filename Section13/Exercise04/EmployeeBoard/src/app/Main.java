package app;

import model.Employee;
import model.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        System.out.println("Enter the number of employees: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Employee #" + i + " data: ");
            System.out.print("Outsourced (y/n)? ");
            char outsourcedOption = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String employeeName =  sc.next();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour ");
            sc.nextLine();
            double valuePerHour = sc.nextDouble();
            if (outsourcedOption == 'y') {
                System.out.print("Additional Charge: ");
                double additionalCharge = sc.nextDouble();
                Employee employee = new OutsourcedEmployee(employeeName, hours, valuePerHour, additionalCharge);
                employees.add(employee);
            } else {
                Employee employee = new Employee(employeeName, hours, valuePerHour);
                employees.add(employee);
            }
        }
        System.out.println("");
        System.out.println("PAYMENTS");
        for (Employee employee : employees) {
            System.out.println(employee.getName() + " - $" + String.format("%.2f", employee.payment()));
        }
        sc.close();
    }
}