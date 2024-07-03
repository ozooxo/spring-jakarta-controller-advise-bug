package com.example.demo

import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.bind.support.WebExchangeBindException

@RestControllerAdvice
class AdditionalHandler {

    @ExceptionHandler(WebExchangeBindException::class)
    protected fun handleException(
        ex: WebExchangeBindException
    ): ProblemDetail {
        return ProblemDetail.forStatusAndDetail(
            HttpStatus.UNAUTHORIZED,
            "override to worse worse worse"
        )
    }
}