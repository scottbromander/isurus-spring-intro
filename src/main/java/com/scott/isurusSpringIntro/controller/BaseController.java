package com.scott.isurusSpringIntro.controller;

import com.scott.isurusSpringIntro.data.EmployeeRepository;
import com.scott.isurusSpringIntro.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class BaseController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(value = "/api/add/employee", method = RequestMethod.POST)
    public @ResponseBody Employee addEmployee(@RequestBody Map<String, Object> payload) {

        String id = String.valueOf(payload.get("id"));
        String firstName = String.valueOf(payload.get("firstName"));
        String lastName = String.valueOf(payload.get("lastName"));
        String position = String.valueOf(payload.get("position"));
        String salary = String.valueOf(payload.get("salary"));

        Employee newEmployee = new Employee(id, firstName, lastName, position, salary);
        employeeRepository.addEmployee(newEmployee);

        return newEmployee;
    }


    @RequestMapping("/api/employees/all")
    public @ResponseBody List<Employee> getEmployees() {
        return employeeRepository.getAllEmployees();
    }



    @RequestMapping("/")
    public String baseRoute() {
        return "index";
    }
}
