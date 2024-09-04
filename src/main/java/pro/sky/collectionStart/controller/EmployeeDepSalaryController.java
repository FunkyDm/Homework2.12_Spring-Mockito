package pro.sky.collectionStart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collectionStart.model.Employee;
import pro.sky.collectionStart.service.impl.EmployeeDepSalaryServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments/")
public class EmployeeDepSalaryController {
    private final EmployeeDepSalaryServiceImpl employeeDepSalaryServiceImpl;

    public EmployeeDepSalaryController(EmployeeDepSalaryServiceImpl employeeDepSalaryServiceImpl) {
        this.employeeDepSalaryServiceImpl = employeeDepSalaryServiceImpl;
    }

    @GetMapping("all")
    public Map<Integer,List<Employee>> getEmployees() {
        return employeeDepSalaryServiceImpl.getEmployees();
    }

    @GetMapping("all-by-dep")
    public List<Employee> getEmployeesByDep(@RequestParam(value = "departmentId") int departmentId) {
        return employeeDepSalaryServiceImpl.getEmployeesByDep(departmentId);
    }

    @GetMapping("max-salary")
    public Employee getEmployeeDepMaxSalary(@RequestParam(value = "departmentId") int departmentId) {
        return employeeDepSalaryServiceImpl.getEmployeeDepMaxSalary(departmentId);
    }

    @GetMapping("min-salary")
    public Employee getEmployeeMinSalary(@RequestParam(value = "departmentId") int departmentId) {
        return employeeDepSalaryServiceImpl.getEmployeeDepMinSalary(departmentId);
    }

}
