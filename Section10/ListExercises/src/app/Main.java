package app;

import model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("How many employees will be registered?");
        int employeesNumber = sc.nextInt();

        List<Employee> employees = new ArrayList<>();

        for (int x = 0; x < employeesNumber; x++) {
            System.out.println("Enter the id of the #" + (x+1) + " employee: ");
            Integer id = sc.nextInt();
            System.out.println("Enter the name of the #" + (x+1) + " employee: ");
            String name = sc.next();
            System.out.println("Enter the salary of the #" + (x+1) + " employee: ");
            Double salary = sc.nextDouble();

            Employee newEmployee = new Employee(id, name, salary);
            employees.add(newEmployee);

        }

        System.out.println("Enter the employee id that will receive a salary increase: ");
        Integer raiseId = sc.nextInt();
        Employee employeeToReceiveRaise = employees.stream().filter(x -> x.getId() == raiseId).findFirst().orElse(null);

        if (employeeToReceiveRaise == null){
            System.out.println("This id does not exist!");
        }else{
            System.out.println("Enter the percentage of salary increase: ");
            Double percentageIncrease = sc.nextDouble();
            employeeToReceiveRaise.increaseSalaryByPercentage(percentageIncrease);
        }

        System.out.println("Employee list: ");

        for (Employee emp: employees) {
            System.out.println(emp);
        }

        sc.close();
    }
}