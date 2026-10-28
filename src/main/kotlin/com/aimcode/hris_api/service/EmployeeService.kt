package com.aimcode.hris_api.service

import com.aimcode.hris_api.exception.GlobalExceptionHandler
import com.aimcode.hris_api.exception.ResourceNotFoundException
import com.aimcode.hris_api.model.Employee
import com.aimcode.hris_api.repository.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeService(
    private val employeeRepository: EmployeeRepository,
    private val globalExceptionHandler: GlobalExceptionHandler
) {

    fun getAllEmployees(): List<Employee> {
        return employeeRepository.findAll()
    }

    fun findById(id: String): Employee {
        return employeeRepository.findById(id) ?: throw ResourceNotFoundException("Employee dengan id $id tidak ditemukan")
    }
}