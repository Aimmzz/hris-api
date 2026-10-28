package com.aimcode.hris_api.controller

import com.aimcode.hris_api.dto.EmployeeRequest
import com.aimcode.hris_api.dto.EmployeeResponse
import com.aimcode.hris_api.model.Employee
import com.aimcode.hris_api.service.EmployeeService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/")
class EmployeeController(
    private val employeeService: EmployeeService
) {

    @GetMapping("employees")
    fun getEmployees(): List<Employee> {
        return employeeService.getAllEmployees()
    }

    @GetMapping("employees/{id}")
    fun getEmployeeById(@PathVariable("id") id: String): EmployeeResponse {
        val employee = employeeService.findById(id)
        return EmployeeResponse(
            id = employee.id,
            name = employee.name,
            position = employee.position,
        )
    }

    @PostMapping("employee")
    @ResponseStatus(HttpStatus.CREATED)
    fun createEmployee(
        @Valid @RequestBody request: EmployeeRequest
    ): EmployeeResponse {
        val generatedId = "3"
        return EmployeeResponse(
            id = generatedId,
            name = request.name,
            position = request.position,
        )
    }
}