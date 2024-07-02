package com.example.demo

import jakarta.validation.Valid
import jakarta.validation.constraints.Size
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated

@Validated
@Service
class Service {

    data class ServiceDataClass(
        @field:Size(min = 1, max = 5)
        val name: String
    )

    fun validateDataClass(@Valid data: ServiceDataClass) {}
}