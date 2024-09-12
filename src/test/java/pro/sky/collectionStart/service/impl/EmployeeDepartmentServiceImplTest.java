package pro.sky.collectionStart.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.collectionStart.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmployeeDepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeServiceImpl;

    @InjectMocks
    private EmployeeDepartmentServiceImpl out;

//    private static final Collection<Employee> employees = List.of(
//            Employee employee1 = new Employee("aboba", "aboba", 5.0, 5)
//    );
//
//    @Test
//    void getEmployees() {
//        return employeeServiceImpl.printAllEmployees()
//                .stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment));
//    }

    @Test
    void getEmployeesByDep() {
    }

    @Test
    void getEmployeeDepMaxSalary() {
    }

    @Test
    void getEmployeeDepMinSalary() {
    }

    @Test
    void getEmployeeDepSalarySum() {
    }
}