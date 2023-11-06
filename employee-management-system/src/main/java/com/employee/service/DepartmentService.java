package com.employee.service;

import com.employee.repository.DepartmentRepository;
import com.employee.document.Department;
import com.employee.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    public Department createDepartment(Department department) {
        Department savedDepartment = departmentRepository.save(department);
        return savedDepartment;
    }

    public Department findByDepartmentId(String departmentId) {
        Optional<Department> optionalEntity = Optional.ofNullable(findByDepartmentId(departmentId));
        boolean isDepartmentAvailable = optionalEntity.isPresent();
        if (isDepartmentAvailable) {
            Department savedDepartment = optionalEntity.get();
            return savedDepartment;
        }
        return null;
    }

    public Status updateDepartment(String departmentId, Department department) {
        Department savedDepartment = findByDepartmentId(departmentId);
        if (Objects.nonNull(savedDepartment)) {
            savedDepartment.setDepartmentId(department.getDepartmentId());
            savedDepartment.setDepartmentName(department.getDepartmentName());
            savedDepartment.setCreatedAt(department.getCreatedAt());
            departmentRepository.save(savedDepartment);
            return Status.SUCCESS;
        }
        return Status.FAILED;
    }

    public Status removeDepartment(String departmentId) {
        departmentRepository.deleteById(departmentId);
        return Status.SUCCESS;
    }
}
