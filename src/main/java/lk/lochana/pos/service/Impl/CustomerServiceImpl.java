package lk.lochana.pos.service.Impl;


import lk.lochana.pos.dto.CustomerDto;
import lk.lochana.pos.entity.Customer;
import lk.lochana.pos.repository.CustomerRepository;
import lk.lochana.pos.service.CustomerService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository cusRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public void saveCustomer(CustomerDto customerdto) {
        if(cusRepo.existsById(customerdto.getId())){
            throw new RuntimeException("Customer already exist");
        }
        Customer customer = modelMapper.map(customerdto, Customer.class);
        cusRepo.save(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        if(!cusRepo.existsById(id)){
            throw new RuntimeException("No such customer");
        }
        Optional<Customer> customer = cusRepo.findById(id);
        cusRepo.delete(customer.get());
    }

    @Override
    public void updateCustomer(CustomerDto customerdto) {
        if(!cusRepo.existsById(customerdto.getId())){
            throw new RuntimeException("No such customer to update");
        }
        Customer customer = modelMapper.map(customerdto, Customer.class);
        cusRepo.save(customer);
    }

    @Override
    public CustomerDto searchCustomer(String id) {
        if(!cusRepo.existsById(id)){
            throw new RuntimeException("No such customer");
        }
        return modelMapper.map(cusRepo.findById(id).get(), CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<Customer> all = cusRepo.findAll();
        return modelMapper.map(all, new TypeToken<List<Customer>>(){}.getType());

    }

}
