package lk.lochana.pos.advisor;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideAdvisor {

    @ExceptionHandler({Exception.class})
    public String handleMyEx(Exception ex){
        return ex.getMessage();
    }
}
