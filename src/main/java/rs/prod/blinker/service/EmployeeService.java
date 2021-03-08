package rs.prod.blinker.service;

import rs.prod.blinker.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee save(Employee employee);

    Employee update(Employee employee);

    Employee findById(Integer employeeId);

    void deleteById(Integer employeeId);

}