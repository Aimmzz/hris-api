package com.aimcode.hris_api.controller

import com.aimcode.hris_api.model.Employee
import com.aimcode.hris_api.service.EmployeeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/employees")
class EmployeeController(
    private val employeeService: EmployeeService
) {

    @GetMapping
    fun getEmployees(): List<Employee> {
        return employeeService.getAllEmployees()
    }
}