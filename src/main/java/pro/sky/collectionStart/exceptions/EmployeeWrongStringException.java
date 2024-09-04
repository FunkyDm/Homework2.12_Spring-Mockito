package pro.sky.collectionStart.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Имя и фамилия сотрудника должны содержать только буквенные символы")
public class EmployeeWrongStringException extends RuntimeException{
    public EmployeeWrongStringException(String message) {
        super(message);
    }
}
