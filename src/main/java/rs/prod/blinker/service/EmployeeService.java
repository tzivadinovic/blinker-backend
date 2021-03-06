package rs.prod.blinker.service;

import java.util.Collection;
import java.util.List;
import rs.prod.blinker.entity.*;

public interface EmployeeService {

	List<Employee> findAll();

	Employee save(Employee employee);

	Employee update(Employee employee);

	Employee findById(Integer employeeId);

	void deleteById(Integer employeeId);

}