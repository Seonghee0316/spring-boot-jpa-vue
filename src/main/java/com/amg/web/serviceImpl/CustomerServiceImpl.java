package com.amg.web.serviceImpl;

import com.amg.web.common.util.PageProxy;
import com.amg.web.domain.CustomerDTO;
import com.amg.web.service.CustomerService;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * CustomerServiceImpl
 */
@Service
public class CustomerServiceImpl implements CustomerService{

    @Override
    public void addCustomer(CustomerDTO customer) {
       
    }

    @Override
    public List<CustomerDTO> findCustomers(PageProxy pxy) {
        return null;
    }

    @Override
    public List<CustomerDTO> findCustomersByOption(CustomerDTO option) {
        return null;
    }

    @Override
    public CustomerDTO findCustomerByCustomerId(String customerId) {
        return null;
    }

    @Override
    public int updateCustomer(CustomerDTO customer) {

        return 0;
    }

    @Override
    public void deleteCustomer(CustomerDTO customer) {

    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public CustomerDTO login(CustomerDTO customer) {
        System.out.println("컨트롤러에서 넘어온 ID: " + customer.getCustomerId());
        System.out.println("컨트롤러에서 넘어온 PASS: " + customer.getPassword());
        return null;
    }

}