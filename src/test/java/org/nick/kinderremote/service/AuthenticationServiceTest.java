package org.nick.kinderremote.service;

import org.junit.jupiter.api.Test;
import org.nick.kinderremote.data.entity.authorithy.Customer;
import org.nick.kinderremote.data.entity.authorithy.Session;
import org.nick.kinderremote.repository.CustomerRepository;
import org.nick.kinderremote.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AuthenticationServiceTest {
    @Autowired
    SessionRepository sesRepo;
    @Autowired
    CustomerRepository custRepo;
    @Autowired
    CustomerService custServ;

    @Test
    void findCustomerBySession(){
        Customer customer = custServ.retrieveCustomer("60d6a84d-4c55-4484-9f9d-7086f16439b");
        assertNotNull(customer);
//        assertThat(!customer.isEmpty());
        System.out.println("CUSTOMER\n"+customer);
    }

    @Test
    void findCustomerById(){
        Optional<Customer> customer = custRepo.findById(95L);
        assertNotNull(customer);
        assertThat(customer.get() instanceof Customer);
        assert (!customer.get().getFirstname().isEmpty() );
        System.out.println(customer.toString());
    }

    @Test

    void createNewSession() {
//        Session session = sesRepo.findByUuid("fd665177-29dd-4e27-9940-02fc92438bcd");
        Session session = sesRepo.findByUuid("60d6a84d-4c55-4484-9f9d-7086f16439b");
        assertTrue(session != null);
        assertThat(session instanceof Session);
        Customer customer = session.getCustomer();
        System.out.println("Customer:\n"+customer);
        System.out.println("Session:\n"+session.toString());
    }

    @Test
    void processAuthorisation() {
    }
}