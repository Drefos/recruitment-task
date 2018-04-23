package me.borkowski.rest.controller;

import me.borkowski.model.Employee;
import me.borkowski.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveEmployee(@RequestBody @Valid Employee employee, BindingResult bindingResult) {
        if(!bindingResult.hasErrors()) {
            employeeRepository.save(employee);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }

    }
}
