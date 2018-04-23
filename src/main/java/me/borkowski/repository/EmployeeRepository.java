package me.borkowski.repository;

import me.borkowski.model.Employee;
import me.borkowski.model.PositionStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT new me.borkowski.model.PositionStatistics(e.position, count(e)) FROM Employee e GROUP BY e.position")
    List<PositionStatistics> countEmployeesPositions();
}
