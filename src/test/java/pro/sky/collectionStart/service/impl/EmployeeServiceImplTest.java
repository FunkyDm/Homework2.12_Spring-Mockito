package pro.sky.collectionStart.service.impl;

import com.github.javafaker.Faker;
import net.bytebuddy.asm.MemberSubstitution;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.collectionStart.exceptions.*;
import pro.sky.collectionStart.model.Employee;
import pro.sky.collectionStart.validation.StringParamValidation;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class EmployeeServiceImplTest {
    private final EmployeeServiceImpl out = new EmployeeServiceImpl(new StringParamValidation());

    private final Faker faker = new Faker();

    private final Random ran = new Random();

    @ParameterizedTest
    @MethodSource("provideParamsForStringContainsOnlyLetters")
    void shouldReturnException_WhenFirstOrLastNameContainsNotOnlyLetters(String message, String firstName, String lastName) {
        Employee expected = new Employee(firstName, lastName, 5000.0, 3);
        assertThrows(EmployeeWrongStringException.class, () -> out.addEmployee(expected.getFirstName(), expected.getLastName(), expected.getSalary(), expected.getDepartment()));
    }

    public static Stream<Arguments> provideParamsForStringContainsOnlyLetters() {
        return Stream.of(
                Arguments.of("Некорректный первый параметр", "123", "Ivanov"),
                Arguments.of("Некорректный второй параметр", "Oleg", "123"),
                Arguments.of("Некорректны оба параметра", "123", "456")
        );
    }

    @Test
    void stringValidationAndCapitalize() {
        String firstName = faker.name().firstName().toLowerCase();
        String lastName = faker.name().firstName().toLowerCase();
        double salary = 5000.0;
        int department = 5;
        Employee actual = out.addEmployee(firstName, lastName, salary, department);
        Employee expected = new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), salary, department);
        assertEquals(expected, actual);
    }

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