package me.borkowski.rest.controller;

import me.borkowski.model.Employee;
import me.borkowski.model.Position;
import me.borkowski.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class CustomDataController {

    private EmployeeRepository employeeRepository;

    @Autowired
    public CustomDataController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("api/loadCustomData")
    public ResponseEntity loadCustomData() {
        List<Employee> employees = Arrays.asList(
                new Employee("Patric", "Star", "thepatric@star.com", Position.DIRECTOR),
                new Employee("Isaac", "Alsop", "meisaac@alsop.com", Position.MANAGER),
                new Employee("Amy", "Walsh", "justamy@walsh.com", Position.MANAGER),
                new Employee("Ania", "Nowak", "takania@nowak.com", Position.HR),
                new Employee("Eric", "Mills", "heric@mills.com", Position.DEV),
                new Employee("Jan", "Rutkowski", "naj@rutkowski.com", Position.DEV),
                new Employee("Tommy", "Michalak", "tomasz@michalak.com", Position.DEV),
                new Employee("Jasmine", "Russell", "justa@russel.com", Position.DEV),
                new Employee("Carl", "Manning", "curl@manning.com", Position.DEV),
                new Employee("Kacper", "Klimek", "kasper@klimek.com", Position.TESTER),
                new Employee("Jason", "Slater", "js@slater.com", Position.TESTER),
                new Employee("Colin", "Greene", "linco@greene.com", Position.TESTER));
        employeeRepository.saveAll(employees);
        return ResponseEntity.ok().build();
    }
}
