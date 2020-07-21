package lk.lochana.pos.Controller;


import lk.lochana.pos.dto.CustomerDto;
import lk.lochana.pos.entity.Customer;
import lk.lochana.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/controller")
public class CustomerController {

   @Autowired
   CustomerService customerService;

    @GetMapping
    public void getCustomer(@RequestBody CustomerDto dto){
        Customer c = new Customer(dto.getId(), dto.getName(), dto.getAge());
        customerService.saveCustomer(c);

    }
}
