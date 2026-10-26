package com.aimcode.hris_api.service

import com.aimcode.hris_api.model.Employee
import com.aimcode.hris_api.repository.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeService(private val employeeRepository: EmployeeRepository) {

    fun getAllEmployees(): List<Employee> {
        return employeeRepository.findAll()
    }
}