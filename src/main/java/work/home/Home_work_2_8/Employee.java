package work.home.Home_work_2_8;
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


}
