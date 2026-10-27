
package com.jaan.employee_leave_management.controller;

import com.jaan.employee_leave_management.entity.EmployeeLeave;
import com.jaan.employee_leave_management.service.EmployeeLeaveService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class EmployeeLeaveController {

    private final EmployeeLeaveService service;

    public EmployeeLeaveController(EmployeeLeaveService service) {
        this.service = service;
    }

    // GET: Retrieve all leave records
    @GetMapping
    public List<EmployeeLeave> getAllLeaves() {
        return service.getAllLeaves();
    }

    // GET: Retrieve a leave record by ID
    @GetMapping("/{id}")
    public EmployeeLeave getLeaveById(@PathVariable Long id) {
        return service.getLeaveById(id);
    }

    // POST: Create a leave request
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeLeave createLeave(
            @Valid @RequestBody EmployeeLeave leave) {
        return service.createLeave(leave);
    }

    // PUT: Update a leave request
    @PutMapping("/{id}")
    public EmployeeLeave updateLeave(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeLeave leave) {
        return service.updateLeave(id, leave);
    }

    // DELETE: Delete a leave request
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLeave(@PathVariable Long id) {
        service.deleteLeave(id);
    }
}
