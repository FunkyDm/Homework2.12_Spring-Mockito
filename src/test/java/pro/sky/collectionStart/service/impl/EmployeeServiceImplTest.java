package pro.sky.collectionStart.service.impl;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pro.sky.collectionStart.exceptions.*;
import pro.sky.collectionStart.model.Employee;
import pro.sky.collectionStart.validation.StringParamValidation;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class EmployeeServiceImplTest {
    private final EmployeeServiceImpl out = new EmployeeServiceImpl(new StringParamValidation());

    private final Faker faker = new Faker();

    private final Random ran = new Random();

    @Test
    public void addEmployee() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().firstName();
        double salary = ran.nextDouble();
        int department = ran.nextInt(5);
        Employee actual = new Employee(firstName, lastName, salary, department);
        assertEquals(out.addEmployee(firstName, lastName, salary, department), actual);
    }

    @Test
    public void removeEmployee() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().firstName();
        double salary = ran.nextDouble();
        int department = ran.nextInt(5);
        Employee actual = new Employee(firstName, lastName, salary, department);
        out.addEmployee(firstName, lastName, salary, department);
        assertEquals(out.removeEmployee(firstName, lastName), actual);
    }

    @Test
    public void findEmployee() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().firstName();
        double salary = ran.nextDouble();
        int department = ran.nextInt(5);
        Employee actual = new Employee(firstName, lastName, salary, department);
        out.addEmployee(firstName, lastName, salary, department);
        assertEquals(out.findEmployee(firstName, lastName), actual);
    }

    @Test
    public void printAllEmployees() {
        List<Employee> expected = new ArrayList<>();
        double salary = 5000.0;
        int department = 5;
        for (int i = 0; i < 10; i++) {
            expected.add(out.addEmployee(faker.name().firstName(), faker.name().firstName(), salary, department));
        }
        Collection<Employee> actual = out.printAllEmployees();
        assertTrue(actual.containsAll(expected));
    }

    @Test
    public void shouldReturnException_WhenStorageIsFull() {
        double salary = 5000.0;
        int department = 5;
        for (int i = 0; i < 10; i++) {
            out.addEmployee(faker.name().firstName(), faker.name().firstName(), salary, department);
        }
        assertThrows(EmployeesStorageFullException.class, () -> out.addEmployee(faker.name().firstName(), faker.name().firstName(), salary, department));
    }

    @Test
    public void shouldReturnException_WhenEmployeeNotFound() {
        assertThrows(EmployeeNotFoundExceptions.class, () -> out.findEmployee(faker.name().firstName(), faker.name().firstName()));
    }

    @Test
    public void shouldReturnException_WhenEmployeeAlreadyAdded() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().firstName();
        double salary = 5000.0;
        int department = 5;
        out.addEmployee(firstName, lastName, salary, department);
        assertThrows(EmployeeAlreadyAddedException.class, () -> out.addEmployee(firstName, lastName, salary, department));
    }

    @Test
    public void shouldReturnException_WhenSalaryValueIsWrong() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().firstName();
        double salary = 0.0;
        int department = 5;
        assertThrows(EmployeeWrongSalaryException.class, () -> out.addEmployee(firstName, lastName, salary, department));
    }

    @Test
    public void shouldReturnException_WhenDepartmentValueIsWrong() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().firstName();
        double salary = 5000.0;
        int department = 6;
        assertThrows(EmployeeWrongDepartmentNumberException.class, () -> out.addEmployee(firstName, lastName, salary, department));
    }
}