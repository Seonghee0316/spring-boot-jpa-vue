package com.amg.web.controller;

import java.util.HashMap;

import com.amg.web.common.util.PageProxy;
import com.amg.web.common.util.Printer;
import com.amg.web.domain.CustomerDTO;
import com.amg.web.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CustomerController
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired CustomerService customerService;
    @Autowired CustomerDTO customer;
    @Autowired Printer p;
    @Autowired PageProxy pxy;

    @PostMapping("")
    public HashMap<String,Object> join(@RequestBody CustomerDTO param){
        System.out.println("-------post mapping-------");
        System.out.println("id" + param.getCustomerId());
        
        System.out.println("pw" + param.getPassword());
        System.out.println("name" + param.getCustomerName());
        HashMap<String, Object> map = new HashMap<>();
        map.put("result", "SUCCESS");
        customerService.addCustomer(param);
        return map;
    }

    // 페이지 처리 후 리퀘스트 바디 써야함.
    @GetMapping("/page/{pageNum}")
    public HashMap<String, Object> list(@PathVariable String pageNum){
        // 뭘 담아야지 페이지 프록시가 기능 할수있는가?
        //컨트롤러가 얘네들은 알려줘야지 프록시가 정보를 갖고 해결해줌. 
        //rowCount, page_num, page_size, block_size
        HashMap<String, Object> map = new HashMap<>();
        //list는 add 오버로딩이 add map은 put
        map.put("totalCount", customerService.countAll());
        map.put("page_num", pageNum);
        map.put("page_size", "5");
        map.put("block_size", "5");
        pxy.execute(map);   //PageProxy의 메소드에 map을 넣어줌.
        map.put("list", customerService.findCustomers(pxy));
        map.put("pxy",pxy);
        // list = customerService.findCustomers();
        // for (CustomerDTO customer : list) {
        //     System.out.println(customer.getCustomerId()+" : "
        //                     +customer.getCustomerName()+" : "
        //                     +customer.getPassword()+" : "
        //                     +customer.getSsn()+" : "
        //                     +customer.getPhone()+" : "
        //                     +customer.getCity()+" : "
        //                     +customer.getAddress()+" : "
        //                     +customer.getPostalcode());
        // }
        return map;
    }

    @GetMapping("/count")   
    public String count() {
        System.out.println("CustomerController count() 경로로 들어옴");
        int count = customerService.countAll();
        p.accept("람다가 출력한 고객의 총인원 : "+count);
        return count+"";
    }

    @GetMapping("/{customerId}/{password}")
    public CustomerDTO login(@PathVariable("customerId")String id,
                        @PathVariable("password")String pass){
        
        customer.setCustomerId(id);
        customer.setPassword(pass);
        return customerService.login(customer);
    }

   
    @GetMapping("/{customerId}")
    public CustomerDTO getCustomer(@PathVariable String customerId) {
        System.out.println("ID 검색 진입 : "+customerId);
        return customerService.findCustomerByCustomerId(customerId);
    }

    @PutMapping("/{customerId}")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO param) {
        System.out.println("수정 할 객체: "+param.toString());
        int res = customerService.updateCustomer(param);
        System.out.println("====> "+res);
        if(res == 1){
            customer = customerService.findCustomerByCustomerId(param.getCustomerId());
        }else{
            System.out.println("컨트롤러 수정 실패");
        }
        return customer;
    }

    @DeleteMapping("/{customerId}")
    public HashMap<String,Object> deleteCustomer(@PathVariable String customerId) {
        HashMap<String, Object> map = new HashMap<>();
        customer.setCustomerId(customerId);
        customerService.deleteCustomer(customer);
        map.put("result","탈퇴성공");
        return map;
    }
}