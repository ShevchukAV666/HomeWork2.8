package work.home.Home_work_2_8;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeBookServiceImpl implements EmployeeBookService {
    Map<String, Employee> employees = new HashMap<>();

    public Map<String, Employee> getEmployees() {
        return employees;
    }

    public String addEmployee(String lastName, String firstName, String surName, int salary, String department) {
        Employee employee = new Employee(lastName, firstName, surName, salary, department);
        String fullName = lastName + " " + firstName + " " + surName;
        if (employees.containsKey(fullName)) {
            throw new RuntimeException("Этот сотрудник уже есть в базе");
        }
        employees.put(fullName, employee);
        return employee.toString();
    }

    public String removeEmployee(String lastName, String firstName, String surName) {
        String fullName = lastName + " " + firstName + " " + surName;
        if (!employees.containsKey(fullName)) {
            throw new RuntimeException("Данного сотрудника нет в базе");
        }
        employees.remove(fullName);
        return fullName;
    }

    public String findEmployee(String lastName, String firstName, String surName) {
        String fullName = lastName + " " + firstName + " " + surName;
        if (!employees.containsKey(fullName)) {
            throw new RuntimeException("Данного сотрудника нет в базе");
        }
        return employees.get(fullName).toString();
    }

    public String printEmployees() {
        String empls = "";
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            empls += entry.getKey() + " " + entry.getValue() + "\n";
        }
        return empls;
    }

    public Employee findMaxSalaryByDepartment(String department) {
        return employees.values().stream()
                .filter(e -> e.getDepartment().contains(department))
                .max(Comparator.comparing(e -> e.getSalary()))
                .orElseThrow(() -> new RuntimeException("Employee with max salary is not found"));
    }

    public Employee findMinSalaryByDepartment(String department) {
        return employees.values().stream()
                .filter(e -> e.getDepartment().contains(department))
                .min(Comparator.comparing(e -> e.getSalary()))
                .orElseThrow(() -> new RuntimeException("Employee with min salary is not found"));
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return employees.values().stream()
                .filter(employee -> employee.getDepartment().contains(department))
                .collect(Collectors.toList());
    }

    public Map<String, List<Employee>> getEmployeesByDepartment() {
        return employees.values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

}

