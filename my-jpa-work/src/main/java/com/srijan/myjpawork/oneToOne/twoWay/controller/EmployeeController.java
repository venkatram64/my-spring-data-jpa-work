package com.srijan.myjpawork.oneToOne.twoWay.controller;

import com.srijan.myjpawork.oneToOne.twoWay.model.Employee;
import com.srijan.myjpawork.oneToOne.twoWay.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    /*
    {
        "firstName": "Srijan",
        "lastName": "Veerareddy",
        "email": "srijan.veerareddy@gmail.com",
        "empNo": "100",
        "address":{
            "line1": "Narayanaguda",
            "city": "Hyderabad",
            "state": "TS",
            "zipCode": "12345",
            "country": "India"
        }
    }
     */
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee newEmp = employeeService.createEmployee(employee);
        return ResponseEntity.ok(newEmp);
    }
    /*
    {
        "id": 1,
        "firstName": "Srijan",
        "lastName": "Veerareddy",
        "email": "srijan.veerareddy@gmail.com",
        "empNo": "100",
        "address":{
            "id": 1,
            "line1": "Austin",
            "city": "Austin",
            "state": "TX",
            "zipCode": "12345",
            "country": "US"
        }
    }
     */
    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee newEmp = employeeService.updateEmployee(employee);
        return ResponseEntity.ok(newEmp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("Employee deleted");
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    /*@GetMapping("/{email}")
    public Employee getEmployee(@PathVariable String email){
        return employeeService.getEmployeeByEmail(email);
    }
*/
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }

}
