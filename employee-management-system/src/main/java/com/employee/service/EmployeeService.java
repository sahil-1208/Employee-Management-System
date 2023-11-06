package com.employee.service;

import com.employee.repository.EmployeeRepository;
import com.employee.entity.Employee;
import com.employee.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee addEmployee(Employee employee) {
        Employee savedEmployeeEntity = employeeRepository.save(employee);
        return savedEmployeeEntity;
    }

    public Employee findEmployeeById(Long id) {
        Optional<Employee> optionalEntity = employeeRepository.findById(id);
        boolean isEmployeeDataPresent = optionalEntity.isPresent();
        if (isEmployeeDataPresent) {
            Employee savedEmployeeDetails = optionalEntity.get();
            return savedEmployeeDetails;
        }
        return null;
    }

    public Status updateEmployee(Long id, Employee employee) {
        Employee savedEmployee = findEmployeeById(id);
        if (Objects.nonNull(savedEmployee)) {
            savedEmployee.setFirstName(employee.getFirstName());
            savedEmployee.setLastName(employee.getLastName());
            savedEmployee.setEmail(employee.getEmail());
            savedEmployee.setDepartmentId(employee.getDepartmentId());
            employeeRepository.save(savedEmployee);
            return Status.SUCCESS;
        }
        return Status.FAILED;
    }

    public Status removeEmployee(Long id) {
        employeeRepository.deleteById(id);
        return Status.SUCCESS;
    }

}
