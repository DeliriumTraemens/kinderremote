package org.nick.kinderremote.service;

import org.nick.kinderremote.data.entity.authorithy.Customer;
import org.nick.kinderremote.data.entity.authorithy.Session;
import org.nick.kinderremote.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerService {
private final CustomerRepository custRepo;

    public CustomerService(CustomerRepository custRepo) {
        this.custRepo = custRepo;
    }

    public Customer createNewAnonimousCustomer(Session session){
        Customer forCreate = new Customer();
        forCreate.setFirstname("Anonimous");
        forCreate.setDateAdded(LocalDateTime.now());
        List<Session> ids =forCreate.getSessions();
        ids.add(session);
        System.out.println("IDS++++====="+ids.toString());
        forCreate.setSessions(ids);
        System.out.println("CUSTOMER=========\n"+forCreate);
//        return forCreate;
        return custRepo.save(forCreate);
    }
}
