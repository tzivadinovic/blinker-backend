package rs.prod.blinker.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.prod.blinker.entity.*;
import rs.prod.blinker.service.*;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
	private final EmployeeService employeeService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(employeeService.findAll());
	}

	@GetMapping("/{employeeId}")
	@ApiOperation(value = "", nickname = "getEmployeeById")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer employeeId) {
		return ResponseEntity.ok(employeeService.findById(employeeId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employee));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateEmployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.update(employee));
	}

	@DeleteMapping("/{employeeId}")
	@ApiOperation(value = "", nickname = "deleteEmployeeById")
	public void deleteEmployeeById(@PathVariable Integer employeeId) {
		employeeService.deleteById(employeeId);
	}

}

