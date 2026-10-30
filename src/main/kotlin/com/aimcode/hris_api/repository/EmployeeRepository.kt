package com.aimcode.hris_api.repository

import com.aimcode.hris_api.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

// JpaRepository<TipeEntity, TipeID> otomatis memberikan kita fungsi:
// findAll(), findById(), save(), deleteById(), dll. Tanpa perlu kita coding
@Repository
interface EmployeeRepository : JpaRepository<Employee, String>