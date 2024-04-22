package assessment.namefilter.controller;


import assessment.namefilter.dto.ApiErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.regex.PatternSyntaxException;

@Slf4j
@RestControllerAdvice
public class NameStoreControllerAdvice {

    @ExceptionHandler(PatternSyntaxException.class)
    public ApiErrorMessage invalidRegex(PatternSyntaxException ex) {
        return new ApiErrorMessage("Invalid Regex Syntax");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiErrorMessage validations(Exception ex) {
        log.error("error ",ex);
        return new ApiErrorMessage("Invalid input!");
    }
    @ExceptionHandler(Exception.class)
    public ApiErrorMessage allOtherExceptions(Exception ex) {
        log.error("error ",ex);
        return new ApiErrorMessage("Error Processing your request!");
    }





}
