package ie.atu.cicd_test;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>>showErrors (MethodArgumentNotValidException ex){
        Map<String,Object> errorResponse = new HashMap<>();

        errorResponse.put("timestamp", LocalDateTime.now());

        Map<String,String>errorList = new HashMap<>();
        for(FieldError error:ex.getFieldErrors()){
            String errName = error.getField();
            String errMessage = error.getDefaultMessage();
            errorList.put(errName,errMessage);
        }

        errorResponse.put("errors",errorList);

        return ResponseEntity.status(400).body(errorResponse);
    }
}
