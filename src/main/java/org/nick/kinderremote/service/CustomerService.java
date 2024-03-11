package org.nick.kinderremote.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.nick.kinderremote.data.entity.authorithy.Customer;
import org.nick.kinderremote.data.entity.authorithy.Session;
import org.nick.kinderremote.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository custRepo;
    private final SessionService sesServ;

    @Autowired
    public CustomerService(CustomerRepository custRepo, SessionService sesServ) {
        this.custRepo = custRepo;
        this.sesServ = sesServ;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

    }

    public Customer createNewAnonimousCustomer(Session session) {
        Customer forCreate = new Customer();
        forCreate.setFirstname("Anonimous");
        forCreate.setDateAdded(LocalDateTime.now());
        List<Session> ids = forCreate.getSessions();
        ids.add(session);
        System.out.println("IDS++++=====" + ids.toString());
        forCreate.setSessions(ids);
//        System.out.println("CUSTOMER=========\n"+forCreate);
//        return forCreate;
        return custRepo.save(forCreate);
    }

    public Customer retrieveCustomer(String sessionId) {
        Session session = sesServ.getByUuid(sessionId);
        Customer customer = session.getCustomer();
        System.out.println("CustomerService.retrieveCustomer\n"+customer.getFirstname());
//        Gson gson = new Gson();
//        String result = gson.toJson(customer);
        return customer;
    }
}
