package com.amg.web.service;

import java.util.List;

import com.amg.web.common.util.PageProxy;
import com.amg.web.domain.CustomerDTO;

import org.springframework.stereotype.Component;

/**
 * CustomerService
 */

@Component 
public interface CustomerService {
    public void addCustomer(CustomerDTO customer);
    public List<CustomerDTO> findCustomers(PageProxy pxy);
    public List<CustomerDTO> findCustomersByOption(CustomerDTO option); //값을 여러개 담을 땐 DTO
    public CustomerDTO findCustomerByCustomerId(String customerId);  //하나만 담을때 String도 객체임.
    public int updateCustomer(CustomerDTO customer); 
    public void deleteCustomer(CustomerDTO customer); //삭제할때 아디 비번 같이 받을수있으므로 DTO로
    public int countAll();
    public CustomerDTO login(CustomerDTO customer);
    
}