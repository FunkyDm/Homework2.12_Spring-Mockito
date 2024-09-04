package pro.sky.collectionStart.service;

import pro.sky.collectionStart.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeDepSalaryService {
    Map<Integer, List<Employee>> getEmployees();

    List<Employee> getEmployeesByDep(int departmentId);

    Employee getEmployeeDepMaxSalary(int departmentId);

    Employee getEmployeeDepMinSalary(int departmentId);
}