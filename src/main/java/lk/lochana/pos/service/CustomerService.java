package lk.lochana.pos.service;

import lk.lochana.pos.dto.CustomerDto;
import lk.lochana.pos.entity.Customer;


import java.util.List;
import java.util.Optional;


public interface CustomerService {
    void saveCustomer(CustomerDto customerdto);
    void deleteCustomer(String id);
    void updateCustomer(CustomerDto customerdto);
    CustomerDto searchCustomer(String id);
    List<CustomerDto> getAllCustomer();
    CustomerDto getMyCustomer(String id);
}
