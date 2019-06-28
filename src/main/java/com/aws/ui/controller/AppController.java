package com.aws.ui.controller;

import com.aws.ui.aws.ui.model.EmployeeDTO;
import com.aws.ui.aws.ui.model.EmployeeDTODetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RefreshScope
public class AppController {


    private static RestTemplate restTemplate = new RestTemplate();

    @Value("${message}")
    private String message;

    @GetMapping("/hello")
    String home(ModelMap modal) {
        return "index";
    }
    //"C:\Program Files (x86)\Google\Chrome\Application\chrome.exe" --disable-web-security --user-data-dir="c:/test"

    @Value("${baseurl}")
    private  String baseurl;

    @Value("${addEmployee}")
    private String addEmployee;

    @Value("${updateEmployee}")
    private String updateEmployee;

    @Value("${deleteEmployee}")
    private String deleteEmployee;

    @Value("${getAllEmployee}")
    private String getAllEmployee;

    @Value("${getEmployee}")
    private String getEmployee;

    @GetMapping("/findall")
    public ResponseEntity<List<EmployeeDTO>> getEmployee(){
        EmployeeDTODetails employeeDTODetails= restTemplate.getForObject(baseurl+getAllEmployee, EmployeeDTODetails.class);// repository.findAll();
        return ResponseEntity.ok(employeeDTODetails.getList());


    }

    @PostMapping("/addEmployee")
    public ResponseEntity addEmployee(@Valid @RequestBody EmployeeDTO employee){
        EmployeeDTO employeeDTO=null;
        try {
             employeeDTO = restTemplate.postForObject(baseurl + addEmployee, employee, EmployeeDTO.class);
        }catch (Exception e){
            System.out.println("in catch");
        }
        return ResponseEntity.ok(employeeDTO);
        //return new ResponseEntity<List<Employee>>(employeess, HttpStatus.OK);

    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employee) {

        Map< String, Long > params = new HashMap< String, Long >();
        params.put("id", id);

        restTemplate.put(baseurl + updateEmployee+id, employee, params);

        //return ResponseEntity.ok(employeeDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        restTemplate.delete(baseurl+deleteEmployee+id);
         return ResponseEntity.ok().build();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable("id") long id) {
        //logger.info("Fetching User with id {}", id);
        EmployeeDTO employeeDTO=restTemplate.getForObject(baseurl+getEmployee+id, EmployeeDTO.class);


        //return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        return ResponseEntity.ok(employeeDTO);
    }


}
