package lk.lochana.pos.Controller;


import lk.lochana.pos.Utill.StandardResponse;
import lk.lochana.pos.dto.CustomerDto;
import lk.lochana.pos.entity.Customer;
import lk.lochana.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/controller")
public class CustomerController {

   @Autowired
   CustomerService customerService;

    @GetMapping
    public ResponseEntity<StandardResponse> getCustomers(){
        List<CustomerDto> allCustomer = customerService.getAllCustomer();
        return new ResponseEntity(new StandardResponse(200, "true", allCustomer), HttpStatus.OK);

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StandardResponse> searchCustomer(@PathVariable String id){
        CustomerDto customerDto = customerService.searchCustomer(id);
        return new ResponseEntity(new StandardResponse(200,"true", customerDto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDto customerdto){
        customerService.saveCustomer(customerdto);
        return new ResponseEntity(new StandardResponse(200, "Done", null), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerDto customerdto){
        customerService.updateCustomer(customerdto);
        return new ResponseEntity(new StandardResponse(200, "Done", null), HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity<StandardResponse> deleteCustomer(@RequestParam String id){
        customerService.deleteCustomer(id);
        return new ResponseEntity(new StandardResponse(200, "Done", null), HttpStatus.OK);
    }


    @GetMapping(path = "/id/{id}")
    public ResponseEntity<StandardResponse> getMyCustomer(@PathVariable("id") String id){
        CustomerDto myCustomer = customerService.getMyCustomer(id);
        return new ResponseEntity(new StandardResponse(200, "Done", myCustomer), HttpStatus.OK);
    }




}
