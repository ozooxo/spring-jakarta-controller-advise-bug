package com.example.demo

import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ConstraintViolationExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    protected fun handleMethodArgumentNotValid(
        ex: ConstraintViolationException
    ): ProblemDetail {
        return ProblemDetail.forStatusAndDetail(
            HttpStatus.UNAUTHORIZED,
            "override to bad bad bad"
        )
    }
}