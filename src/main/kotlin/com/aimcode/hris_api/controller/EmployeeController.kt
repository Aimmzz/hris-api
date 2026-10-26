package com.aimcode.hris_api.controller

import com.aimcode.hris_api.model.Employee
import com.aimcode.hris_api.service.EmployeeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
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
    fun getEmployeeById(@PathVariable("id") id: String): Employee? {
        return employeeService.findById(id)
    }
}