package com.example.demo;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoUserIdException.class)
    protected Envelope noUserIdException(NoUserIdException e) {
        ErrorBody error = ErrorBody.builder()
            .status(403)
            .message("클라이언트가 콘텐츠에 접근할 권리를 가지고 있지 않습니다.")
            .build();
        Envelope response = Envelope.builder()
            .success(false)
            .response(null)
            .error(error)
            .build();
        return response;
    }

    @ExceptionHandler(CodeConflictException.class)
    protected Envelope codeConflictException(CodeConflictException e) {
        e.getMessage();
        ErrorBody error = ErrorBody.builder()
            .status(400)
            .message("동일한 code값이 존재합니다.")
            .build();
        Envelope response = Envelope.builder()
            .success(false)
            .response(null)
            .error(error)
            .build();
        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Envelope validException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();

        ErrorBody error = ErrorBody.builder()
            .status(400)
            .message(bindingResult.getFieldErrors().get(0).getDefaultMessage())
            .build();

        Envelope response = Envelope.builder()
            .success(false)
            .response(null)
            .error(error)
            .build();
        return response;
    }
}
