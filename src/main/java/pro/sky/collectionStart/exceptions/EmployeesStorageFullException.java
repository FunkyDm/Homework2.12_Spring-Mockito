package pro.sky.collectionStart.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Больше нельзя добавлять сотрудников.")
public class EmployeesStorageFullException extends RuntimeException {
    public EmployeesStorageFullException(String message) {
        super(message);
    }
}
