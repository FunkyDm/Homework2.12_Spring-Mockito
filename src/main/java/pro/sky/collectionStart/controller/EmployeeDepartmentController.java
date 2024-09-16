package pro.sky.collectionStart.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.collectionStart.model.Employee;
import pro.sky.collectionStart.service.impl.EmployeeDepartmentServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/department/")
public class EmployeeDepartmentController {
    private final EmployeeDepartmentServiceImpl employeeDepSalaryServiceImpl;

    public EmployeeDepartmentController(EmployeeDepartmentServiceImpl employeeDepSalaryServiceImpl) {
        this.employeeDepSalaryServiceImpl = employeeDepSalaryServiceImpl;
    }

    @GetMapping("employees")
    public Map<Integer,List<Employee>> getEmployees() {
        return employeeDepSalaryServiceImpl.getEmployees();
    }

    @GetMapping("{departmentId}/employees")
    public List<Employee> getEmployeesByDep(@PathVariable(value = "departmentId") int departmentId) {
        return employeeDepSalaryServiceImpl.getEmployeesByDep(departmentId);
    }

    @GetMapping("{departmentId}/salary/max")
    public Optional<Employee> getEmployeeDepMaxSalary(@PathVariable(value = "departmentId") int departmentId) {
        return employeeDepSalaryServiceImpl.getEmployeeDepMaxSalary(departmentId);
    }

    @GetMapping("{departmentId}/salary/min")
    public Optional<Employee> getEmployeeMinSalary(@PathVariable(value = "departmentId") int departmentId) {
        return employeeDepSalaryServiceImpl.getEmployeeDepMinSalary(departmentId);
    }

    @GetMapping("{departmentId}/salary/sum")
    public Double getEmployeeDepSalarySum(@PathVariable(value = "departmentId") int departmentId){
        return employeeDepSalaryServiceImpl.getEmployeeDepSalarySum(departmentId);
    }

}
