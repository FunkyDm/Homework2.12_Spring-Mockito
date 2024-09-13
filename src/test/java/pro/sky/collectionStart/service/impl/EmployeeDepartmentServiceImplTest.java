package pro.sky.collectionStart.service.impl;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.collectionStart.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeDepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeServiceImpl;

    @InjectMocks
    private EmployeeDepartmentServiceImpl out;

    private final static Faker faker = new Faker();

    private final static Random ran = new Random();

    private static final Collection<Employee> employees = List.of(
            new Employee(faker.name().firstName(), faker.name().firstName(), ran.nextDouble(1.0, 5000.0), ran.nextInt(1, 5)),
            new Employee(faker.name().firstName(), faker.name().firstName(), ran.nextDouble(1.0, 5000.0), ran.nextInt(1, 5)),
            new Employee(faker.name().firstName(), faker.name().firstName(), ran.nextDouble(1.0, 5000.0), ran.nextInt(1, 5))
    );

//    @Test
//    public void getEmployees() {
//        when(employeeServiceImpl.printAllEmployees()).thenReturn(employees);
//        Map<Integer, List<Employee>> actual = new HashMap<>();
//        Map<Integer, List<Employee>> expected = new HashMap<>();
//        actual = employeeServiceImpl.printAllEmployees()
//                .stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment));
//        for(int i = 0; i < employees.size(); i++){
//            expected.put(employe)
//        }
//    }

    @Test
    public void getEmployeesByDep() {

    }

    @Test
    public void getEmployeeDepMaxSalary() {
    }

    @Test
    public void getEmployeeDepMinSalary() {
    }

    @Test
    public void getEmployeeDepSalarySum() {
    }
}