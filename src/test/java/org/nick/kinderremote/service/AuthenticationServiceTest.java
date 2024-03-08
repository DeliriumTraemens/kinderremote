package org.nick.kinderremote.service;

import org.junit.jupiter.api.Test;
import org.nick.kinderremote.data.entity.authorithy.Session;
import org.nick.kinderremote.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AuthenticationServiceTest {
@Autowired
    SessionRepository sesRepo;

    @Test
    void createNewSession() {
        Session session=sesRepo.findByUuid("fd665177-29dd-4e27-9940-02fc92438bcd");
        assertTrue(session!=null );
        System.out.println(session.toString());
    }

    @Test
    void processAuthorisation() {
    }
}