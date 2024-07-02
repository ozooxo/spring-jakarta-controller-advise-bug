package com.example.demo

import jakarta.validation.Valid
import jakarta.validation.constraints.Size
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@Validated
@RestController
class Controller (
    private val service: Service
){

    data class ControllerDataClass(
        @field:Size(min = 1, max = 5)
        val name: String
    )

    @PostMapping(
        value = ["/validation_error_raised_from_controller"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    suspend fun fromController(
        @Valid @RequestBody data: ControllerDataClass
    ): ResponseEntity<out String> {
        return ResponseEntity.ok()
            .body("success")
    }

    @PostMapping(
        value = ["/validation_error_raised_from_service"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    suspend fun fromService(): ResponseEntity<out String> {
        service.validateDataClass(Service.ServiceDataClass("string_to_long"))
        return ResponseEntity.ok()
            .body("success")
    }
}