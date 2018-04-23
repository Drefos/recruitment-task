package me.borkowski.rest.controller;

import me.borkowski.model.PositionStatistics;
import me.borkowski.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/positions")
public class PositionRestController {

    private EmployeeRepository employeeRepository;

    @Autowired
    public PositionRestController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<PositionStatistics> getPositions() {
        return employeeRepository.countEmployeesPositions();
    }
}
