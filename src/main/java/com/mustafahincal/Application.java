package com.mustafahincal;

import com.mustafahincal.core.utilities.exceptions.BusinessException;
import com.mustafahincal.core.utilities.exceptions.ProblemDetails;
import com.mustafahincal.core.utilities.exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());

		return problemDetails;
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(MethodArgumentNotValidException methodArgumentNotValidException) {
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		validationProblemDetails.setMessage("VALIDATION.EXCEPTION");
		validationProblemDetails.setValidationErrors(new HashMap<>());

		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		return validationProblemDetails;
	}

	@Bean // Spring IoC
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
