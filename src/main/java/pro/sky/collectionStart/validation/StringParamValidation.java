package pro.sky.collectionStart.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import pro.sky.collectionStart.exceptions.EmployeeWrongStringException;

@Component
public class StringParamValidation {
    public String stringValidationAndCapitalize(String param){
        if(StringUtils.isAlpha(param)){
            return StringUtils.capitalize(param.toLowerCase());
        }
        throw new EmployeeWrongStringException("Имя и фамилия сотрудника должны содержать только буквенные символы");
    }

}
