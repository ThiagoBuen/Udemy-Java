package model.service;

import model.Employee;

import java.util.List;
import java.util.function.Predicate;

public class EmployeeService {

    public double filteredSalarySum(List<Employee> employees, Predicate<Employee> criteria) {
        double sum = 0.0;
        for (Employee emp : employees) {
            if (criteria.test(emp)) {
                sum += emp.getSalary();
            }
        }

        return sum;
    }
}
