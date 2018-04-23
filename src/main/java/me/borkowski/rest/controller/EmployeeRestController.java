package me.borkowski.rest.controller;

import me.borkowski.model.Employee;
import me.borkowski.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeRestController {

    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String EMAIL = "email";

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeRestController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployees(@RequestParam(defaultValue = FIRST_NAME) String orderBy) {
        List<Employee> employees = employeeRepository.findAll();
        if (FIRST_NAME.equals(orderBy)) {
            employees.sort(Comparator.comparing(Employee::getFirstName));
        } else if (LAST_NAME.equals(orderBy)) {
            employees.sort(Comparator.comparing(Employee::getLastName));
        } else if (EMAIL.equals(orderBy)) {
            employees.sort(Comparator.comparing(Employee::getEmail));
        }
        return employees;
    }
}
