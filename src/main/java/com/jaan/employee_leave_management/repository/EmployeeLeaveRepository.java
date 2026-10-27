
package com.jaan.employee_leave_management.repository;

import com.jaan.employee_leave_management.entity.EmployeeLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeLeaveRepository
        extends JpaRepository<EmployeeLeave, Long> {
}
