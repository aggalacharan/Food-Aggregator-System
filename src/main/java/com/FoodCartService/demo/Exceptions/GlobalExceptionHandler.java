package com.FoodCartService.demo.Exceptions;

import com.FoodCartService.demo.Model.FoodCart;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.sql.SQLException;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RestaurantException.class)
    public ResponseEntity<ErrorDetails> restaurantExceptionHandler(RestaurantException exc, WebRequest req){

        ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setTimeSpan(LocalDateTime.now());
        errorDetails.setMessage(exc.getMessage());
        errorDetails.setDescription(req.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(CartException.class)
    public ResponseEntity<ErrorDetails> userExceptionHandler(CartException exc, WebRequest req){

        ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setTimeSpan(LocalDateTime.now());
        errorDetails.setMessage(exc.getMessage());
        errorDetails.setDescription(req.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorDetails> sqlExceptionHandler(SQLException exc, WebRequest req){

        ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setTimeSpan(LocalDateTime.now());
        errorDetails.setMessage(exc.getMessage());
        errorDetails.setDescription(req.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }
//
//    @ExceptionHandler(CallNotPermittedException.class)
//    public ResponseEntity<ErrorDetails> callNotPermitedExceptionHandler(CallNotPermittedException exc, WebRequest req){
//
//        ErrorDetails errorDetails = new ErrorDetails();
//
//        errorDetails.setTimeSpan(LocalDateTime.now());
//        errorDetails.setMessage("Connection is open and does not permit any more calls, please try again after sometime");
//        errorDetails.setDescription(req.getDescription(false));
//
//        return new ResponseEntity<>(errorDetails, HttpStatus.SERVICE_UNAVAILABLE);
//
//    }
//
//    @ExceptionHandler(RequestNotPermitted.class)
//    public ResponseEntity<ErrorDetails> handleRequestNotPermitted(RequestNotPermitted exc, WebRequest req) {
//
//        ErrorDetails errorDetails = new ErrorDetails();
//
//        errorDetails.setTimeSpan(LocalDateTime.now());
//        errorDetails.setMessage("Request limit exceeded");
//        errorDetails.setDescription(req.getDescription(false));
//
//        return new ResponseEntity<>(errorDetails, HttpStatus.TOO_MANY_REQUESTS);
//
//    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> genericExceptionHandler(Exception exc, WebRequest req){

        ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setTimeSpan(LocalDateTime.now());
        errorDetails.setMessage(exc.getMessage());
        errorDetails.setDescription(req.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> methodArgumentExceptionHandler(MethodArgumentNotValidException me, WebRequest req)  {

        ErrorDetails errorDetails=new ErrorDetails();

        errorDetails.setTimeSpan(LocalDateTime.now());
        errorDetails.setDescription(req.getDescription(false));
        errorDetails.setMessage(me.getBindingResult().getFieldError().getDefaultMessage());

        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDetails> noHandlerExceptionHandler(NoHandlerFoundException exc, WebRequest req)  {

        ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setTimeSpan(LocalDateTime.now());
        errorDetails.setMessage(exc.getMessage());
        errorDetails.setDescription(req.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }


}
