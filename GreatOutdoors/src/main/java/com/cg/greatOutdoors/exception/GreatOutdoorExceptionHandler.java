package com.cg.greatOutdoors.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GreatOutdoorExceptionHandler {
	
	@ExceptionHandler(value= {ProductException.class})
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public  ErrorInfo handlerException1(Exception e)
	{
		return new ErrorInfo(e.getMessage());
	}

}
