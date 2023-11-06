package com.employee.controller;

import com.employee.document.Department;
import com.employee.enums.Status;
import com.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @GetMapping("/{departmentId}")
    public Department findByDepartmentId(@PathVariable String departmentId) {
        return departmentService.findByDepartmentId(departmentId);
    }

    @PutMapping("/{departmentId}")
    public Status updateDepartment(@PathVariable String departmentId, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    @DeleteMapping("/{departmentId}")
    public Status removeDepartment(String departmentId) {
        return departmentService.removeDepartment(departmentId);
    }
}
