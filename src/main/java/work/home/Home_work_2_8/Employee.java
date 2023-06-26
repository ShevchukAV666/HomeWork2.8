package work.home.Home_work_2_8;

import java.util.Objects;

public class Employee {
    private static int id;
    private final int EmployeeId;
    private String lastName;
    private String firstName;
    private String surName;
    private int salary;
    private String department;

    public Employee(String lastName, String firstName, String surName, int salary, String department) {
        this.EmployeeId = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.surName = surName;
        this.salary = salary;
        this.department = department;
        id++;
    }

    @Override
    public String toString() {
        return "ID: " + this.EmployeeId + ", last name: " + this.lastName + ", first name: "
                + this.firstName + ", sur name: " + this.surName
                + ", salary: " + this.salary + ", department: " + this.department;


    }

    public String getFullName(){
        return lastName + " " + firstName + " " + surName;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return EmployeeId == employee.EmployeeId && salary == employee.salary && Objects.equals(lastName, employee.lastName) && Objects.equals(firstName, employee.firstName) && Objects.equals(surName, employee.surName) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(EmployeeId, lastName, firstName, surName, salary, department);
    }

}
