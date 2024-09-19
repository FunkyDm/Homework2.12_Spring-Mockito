package pro.sky.collectionStart.service;

import pro.sky.collectionStart.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EmployeeDepartmentService {
    Map<Integer, List<Employee>> getEmployees();

    List<Employee> getEmployeesByDep(int departmentId);

    double getEmployeeDepMaxSalary(int departmentId);

    double getEmployeeDepMinSalary(int departmentId);

    double getEmployeeDepSalarySum(int departmentId);

}