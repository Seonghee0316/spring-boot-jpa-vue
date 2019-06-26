package com.amg.web.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;




/**
 * CustomerDTO
 */
@Data @Component @Lazy
public class CustomerDTO {
    private String customerId, customerName, password, ssn, phone, city, address, postalcode, photo;

    // public String getCustomerId() {
    //     return customerId;
    // }

    // public String getPhoto() {
    //     return photo;
    // }

    // public void setPhoto(String photo) {
    //     this.photo = photo;
    // }

    // public String getPostalcode() {
    //     return postalcode;
    // }

    // public void setPostalcode(String postalcode) {
    //     this.postalcode = postalcode;
    // }

    // public String getAddress() {
    //     return address;
    // }

    // public void setAddress(String address) {
    //     this.address = address;
    // }

    // public String getCity() {
    //     return city;
    // }

    // public void setCity(String city) {
    //     this.city = city;
    // }

    // public String getPhone() {
    //     return phone;
    // }

    // public void setPhone(String phone) {
    //     this.phone = phone;
    // }

    // public String getSsn() {
    //     return ssn;
    // }

    // public void setSsn(String ssn) {
    //     this.ssn = ssn;
    // }

    // public String getPassword() {
    //     return password;
    // }

    // public void setPassword(String password) {
    //     this.password = password;
    // }

    // public String getCustomerName() {
    //     return customerName;
    // }

    // public void setCustomerName(String customerName) {
    //     this.customerName = customerName;
    // }

    // public void setCustomerId(String customerId) {
    //     this.customerId = customerId;
    // }
    
}