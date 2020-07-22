package lk.lochana.pos.service;

import lk.lochana.pos.dto.CustomerDto;


import java.util.List;


public interface CustomerService {
    void saveCustomer(CustomerDto customerdto);
    void deleteCustomer(String id);
    void updateCustomer(CustomerDto customerdto);
    CustomerDto searchCustomer(String id);
    List<CustomerDto> getAllCustomer();
}
