package lk.lochana.pos.advisor;

import lk.lochana.pos.Utill.StandardResponse;
import lk.lochana.pos.handler.AppException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideAdvisor {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<StandardResponse> handleMyEx(Exception ex){
        return new ResponseEntity(new StandardResponse(500,"error", ex.getMessage()), HttpStatus.OK);
    }

  /*  @ExceptionHandler({AppException.class})
    public String handleMyEx2(AppException ex){
        return ex.getMessage();
    }*/
}
