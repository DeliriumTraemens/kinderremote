package org.nick.kinderremote.service;

import org.nick.kinderremote.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
private final CustomerRepository custRepo;

    public CustomerService(CustomerRepository custRepo) {
        this.custRepo = custRepo;
    }
}
