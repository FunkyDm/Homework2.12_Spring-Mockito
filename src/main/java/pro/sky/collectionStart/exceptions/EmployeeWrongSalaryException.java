package pro.sky.collectionStart.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Установлено неправильное значение зарплаты.")
public class EmployeeWrongSalaryException extends RuntimeException{
    public EmployeeWrongSalaryException(String message) {
        super(message);
    }
}
