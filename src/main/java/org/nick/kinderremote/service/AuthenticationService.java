package org.nick.kinderremote.service;

import org.nick.kinderremote.data.entity.authorithy.Session;
import org.nick.kinderremote.repository.CustomerRepository;
import org.nick.kinderremote.repository.SessionRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
private final SessionRepository sesRepo;
private final CustomerRepository custRepo;

    public AuthenticationService(SessionRepository sesRepo, CustomerRepository custRepo) {
        this.sesRepo = sesRepo;
        this.custRepo = custRepo;
    }

    public Session createNewSession(String uuid){
        return null;
    }
}
