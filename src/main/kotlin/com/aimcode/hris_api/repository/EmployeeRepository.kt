package com.aimcode.hris_api.repository

import com.aimcode.hris_api.model.Employee
import org.springframework.stereotype.Repository

@Repository
class EmployeeRepository {

    private val employees = mutableListOf(
        Employee("1", "Rohim Kurniawan", "Mobile Developer"),
        Employee("2", "Jhon Doe", "Backend Developer"),
    )

    fun findAll(): List<Employee> = employees

    fun findById(id: String): Employee? {
        return employees.find { it.id == id }
    }
}