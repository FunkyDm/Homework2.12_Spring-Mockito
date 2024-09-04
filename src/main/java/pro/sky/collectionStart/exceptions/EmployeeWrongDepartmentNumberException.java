package pro.sky.collectionStart.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Установлен неправильный номер отдела.")
public class EmployeeWrongDepartmentNumberException extends RuntimeException{
    public EmployeeWrongDepartmentNumberException(String message) {
        super(message);
    }
}
