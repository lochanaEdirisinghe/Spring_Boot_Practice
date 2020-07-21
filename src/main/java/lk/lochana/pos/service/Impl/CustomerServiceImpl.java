package lk.lochana.pos.service.Impl;


import lk.lochana.pos.entity.Customer;
import lk.lochana.pos.repository.CustomerRepository;
import lk.lochana.pos.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository cusRepo;


    @Override
    public void saveCustomer(Customer customer){
        cusRepo.save(customer);
    }

}
