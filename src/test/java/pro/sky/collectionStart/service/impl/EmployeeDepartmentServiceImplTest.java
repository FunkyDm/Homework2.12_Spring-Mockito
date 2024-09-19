package pro.sky.collectionStart.service.impl;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.collectionStart.exceptions.EmployeeWrongDepartmentNumberException;
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

    @Test
    public void getEmployees() {
        when(employeeServiceImpl.printAllEmployees()).thenReturn(employees);
        Map<Integer, List<Employee>> expected = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        Map<Integer, List<Employee>> actual = out.getEmployees();

        assertEquals(expected,actual);
    }

    @Test
    public void getEmployeesByDep() {
        when(employeeServiceImpl.printAllEmployees()).thenReturn(employees);
        int department = ran.nextInt(1, 5);
        List<Employee> expected = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                expected.add(employee);
            }
        }

        List<Employee> actual = out.getEmployeesByDep(department);

        assertEquals(expected, actual);
    }

    @Test
    public void getEmployeeDepMaxSalary() {
        when(employeeServiceImpl.printAllEmployees()).thenReturn(employees);
        int department = ran.nextInt(1, 5);
        Optional.of(department)
                .filter(id -> id >= 1 && id <= 5)
                .orElseThrow(() -> new EmployeeWrongDepartmentNumberException("Установлен неправильный номер отдела."));
        double expected = employees.stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .map(Employee::getSalary)
                .orElse(0.0);

        double actual = out.getEmployeeDepMaxSalary(department);

        assertEquals(expected, actual);
    }

    @Test
    public void getEmployeeDepMinSalary() {
        when(employeeServiceImpl.printAllEmployees()).thenReturn(employees);
        int department = ran.nextInt(1, 5);
        Optional.of(department)
                .filter(id -> id >= 1 && id <= 5)
                .orElseThrow(() -> new EmployeeWrongDepartmentNumberException("Установлен неправильный номер отдела."));
        double expected = employees.stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .map(Employee::getSalary)
                .orElse(0.0);

        double actual = out.getEmployeeDepMinSalary(department);

        assertEquals(expected, actual);
    }

    @Test
    public void getEmployeeDepSalarySum() {
        when(employeeServiceImpl.printAllEmployees()).thenReturn(employees);
        int department = ran.nextInt(1, 5);
        Optional.of(department)
                .filter(id -> id >= 1 && id <= 5)
                .orElseThrow(() -> new EmployeeWrongDepartmentNumberException("Установлен неправильный номер отдела."));
        double expected = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                expected += employee.getSalary();
            }
        }

        double actual = out.getEmployeeDepSalarySum(department);

        assertEquals(expected, actual);
    }
}