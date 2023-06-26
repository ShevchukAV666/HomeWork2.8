package work.home.Home_work_2_8;

import java.util.List;
import java.util.Map;

public interface EmployeeBookService {
    String addEmployee(String lastName, String firstName, String surName, int salary, String department);

    Map<String, Employee> getEmployees();

    String printEmployees();

    String removeEmployee(String lastName, String firstName, String surName);

    String findEmployee(String lastName, String firstName, String surName);

    Employee findMaxSalaryByDepartment(String department);

    Employee findMinSalaryByDepartment(String department);

    List<Employee> getEmployeesByDepartment(String department);

    String getEmployeesDepartmentsAll();



}
