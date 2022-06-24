package com.apnafoodcourt.cloudkitchenservice.customer;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    public Customer findByPhoneNumber(String phoneNumber);
}
