package work.home.Home_work_2_8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/employee")
public class EmployeeBookController {
    private final EmployeeBookService employeeBookService;

    public EmployeeBookController(EmployeeBookService employeeBookService) {
        this.employeeBookService = employeeBookService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("lastName") String lastName,
                              @RequestParam("firstName") String firstName,
                              @RequestParam("surName") String surName,
                              @RequestParam("salary") int salary,
                              @RequestParam("department") String department) {
        return employeeBookService.addEmployee(lastName, firstName, surName, salary, department);
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam("lastName") String lastName,
                                 @RequestParam("firstName") String firstName,
                                 @RequestParam("surName") String surName) {
        return employeeBookService.removeEmployee(lastName, firstName, surName);
    }

    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("lastName") String lastName,
                               @RequestParam("firstName") String firstName,
                               @RequestParam("surName") String surName) {
        return employeeBookService.findEmployee(lastName, firstName, surName);
    }

    @GetMapping(path = "/print")
    public String printEmployees() {
        return employeeBookService.printEmployees();
    }

    @GetMapping(path = "/departments/max-salary")
    public Employee findMaxSalaryByDepartment(@RequestParam ("department") String department){
        return employeeBookService.findMaxSalaryByDepartment(department);
    }

    @GetMapping(path = "/departments/min-salary")
    public Employee findMinSalaryByDepartment(@RequestParam ("department") String department){
        return employeeBookService.findMinSalaryByDepartment(department);
    }

    @GetMapping(path = "departments/all", params = "departmentId")
    public List<Employee> getEmployeesByDepartment(@RequestParam ("departmentId") String department){
        return employeeBookService.getEmployeesByDepartment(department);
    }

    @GetMapping(path = "/departments/all")
    public Map<String, List<Employee>> getEmployeesByDepartmentAll() {
        return employeeBookService.getEmployeesByDepartment();
    }
}