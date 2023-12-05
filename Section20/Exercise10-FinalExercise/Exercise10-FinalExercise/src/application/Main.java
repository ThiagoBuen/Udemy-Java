package application;

import model.Employee;
import model.service.EmployeeService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter full file path: ");
        String path = sc.nextLine();

        System.out.println("Enter a value for the salary filter: ");
        Double filterSalary = sc.nextDouble();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            List<Employee> list = new ArrayList<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> emails = list.stream()
                    .filter(emp -> emp.getSalary() > filterSalary)
                    .map(p -> p.getEmail())
                    .sorted(comp)
                    .toList();
            System.out.println("Email of the employees whose salary is more  than " + filterSalary + ":");
            emails.forEach(System.out::println);

            EmployeeService empServices = new EmployeeService();

            Predicate<Employee> predicateEmployee = emp -> emp.getName().charAt(0) == 'M';

            double salarySum = empServices.filteredSalarySum(list, predicateEmployee);

            System.out.println("Salary sum of employees whose name starts with 'M' : " + salarySum);

        }catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}