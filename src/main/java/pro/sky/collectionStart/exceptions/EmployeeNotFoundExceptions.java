package pro.sky.collectionStart.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Такого сотрудника не существует.")
public class EmployeeNotFoundExceptions extends RuntimeException {
    public EmployeeNotFoundExceptions(String message) {
        super(message);
    }
}