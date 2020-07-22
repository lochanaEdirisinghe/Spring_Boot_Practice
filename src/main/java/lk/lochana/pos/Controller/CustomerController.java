package lk.lochana.pos.Controller;


import lk.lochana.pos.dto.CustomerDto;
import lk.lochana.pos.entity.Customer;
import lk.lochana.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/controller")
public class CustomerController {

   @Autowired
   CustomerService customerService;

    @GetMapping
    public List<CustomerDto> getCustomers(){
        return customerService.getAllCustomer();

    }

    @GetMapping(path = "/{id}")
    public CustomerDto searchCustomer(@PathVariable String id){
        return customerService.searchCustomer(id);
    }

    @PostMapping
    public void saveCustomer(@RequestBody CustomerDto customerdto){
        customerService.saveCustomer(customerdto);

    }

    @PutMapping
    public void updateCustomer(@RequestBody CustomerDto customerdto){
        customerService.updateCustomer(customerdto);
    }

    @DeleteMapping(params = {"id"})
    public void deleteCustomer(@RequestParam String id){
        customerService.deleteCustomer(id);
    }




}
