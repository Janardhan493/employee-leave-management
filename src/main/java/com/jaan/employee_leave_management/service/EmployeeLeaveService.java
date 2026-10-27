
package com.jaan.employee_leave_management.service;

import com.jaan.employee_leave_management.entity.EmployeeLeave;
import com.jaan.employee_leave_management.exception.ResourceNotFoundException;
import com.jaan.employee_leave_management.repository.EmployeeLeaveRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeLeaveService {

    private final EmployeeLeaveRepository repository;

    public EmployeeLeaveService(EmployeeLeaveRepository repository) {
        this.repository = repository;
    }

    // Get all leave records
    public List<EmployeeLeave> getAllLeaves() {
        return repository.findAll();
    }

    // Get one leave record by ID
    public EmployeeLeave getLeaveById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Leave record not found with ID: " + id));
    }

    // Create a new leave record
    public EmployeeLeave createLeave(EmployeeLeave leave) {
        leave.setId(null);
        return repository.save(leave);
    }

    // Update an existing leave record
    public EmployeeLeave updateLeave(
            Long id, EmployeeLeave updatedLeave) {

        EmployeeLeave existingLeave = getLeaveById(id);

        existingLeave.setEmployeeName(updatedLeave.getEmployeeName());
        existingLeave.setLeaveType(updatedLeave.getLeaveType());
        existingLeave.setNumberOfDays(updatedLeave.getNumberOfDays());
        existingLeave.setReason(updatedLeave.getReason());

        return repository.save(existingLeave);
    }

    // Delete a leave record
    public void deleteLeave(Long id) {
        EmployeeLeave leave = getLeaveById(id);
        repository.delete(leave);
    }
}
