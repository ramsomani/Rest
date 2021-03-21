package com.socgen.ndod.controller;

import com.socgen.ndod.modal.Employee;
import com.socgen.ndod.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;
import javax.xml.ws.Response;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("v1/hello")
public class HelloController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployeeDetails(){
           List<Employee> emp =  employeeService.getEmployeeDetails();

        /*HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<Employee>(emp,headers);

         ResponseEntity et = restTemplate.exchange(
                "http://localhost:8080/products", HttpMethod.POST, entity, Employee.class);*/


        return new ResponseEntity(emp, HttpStatus.OK);
    }

    @GetMapping("/{sal}")
    public ResponseEntity<Employee> getEmployeeBySal(@PathVariable("sal") Double sal){
            Employee emp = employeeService.getEmployeeBySal(sal);
            return new ResponseEntity(emp, HttpStatus.OK);
    }
}
