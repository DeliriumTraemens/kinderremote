package org.nick.kinderremote.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.nick.kinderremote.data.dto.AuthorisationDto;
import org.nick.kinderremote.data.entity.authorithy.Customer;
import org.nick.kinderremote.data.entity.authorithy.Session;
import org.nick.kinderremote.repository.CustomerRepository;
import org.nick.kinderremote.repository.SessionRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Service
public class AuthenticationService {
    private final SessionRepository sesRepo;
    private final CustomerRepository custRepo;
    private final SessionService sesService;
    private final CustomerService custService;

    public AuthenticationService(SessionRepository sesRepo, CustomerRepository custRepo, SessionService sesService, CustomerService custService) {
        this.sesRepo = sesRepo;
        this.custRepo = custRepo;
        this.sesService = sesService;
        this.custService = custService;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public Session createNewSession(String uuid) {

        return null;
    }

    public String processAuthorisation(String sessionId, HttpServletRequest request) {
        Session newSession = new Session();
        if (!sesService.chekIsExistedSession(sessionId)) {
            newSession = sesService.createNewSession(sessionId);
/* Добавить в сущность флаг обращения к сущности - если флаг отрицательный,
можно создать Покупателя, если положительный, то можно искать покупателя.
Так же можно в сущность сессии добавить айди Кастомера
fd665177-29dd-4e27-9940-02fc92438bcd*/

        }
        Customer newCustomer = custService.createNewAnonimousCustomer(newSession);
        newSession.setCustomer(newCustomer);
        sesRepo.save(newSession);
        AuthorisationDto forSend = new AuthorisationDto();
        forSend.setUsername(newCustomer.getFirstname());
        forSend.setSessionId(sessionId);
        forSend.setCreatedAt(LocalDateTime.now());
        forSend.setToken(newCustomer.getFirstname() + sessionId);
//Create Dto for send out
        Gson gson=new Gson();
        String result= gson.toJson(forSend);
        System.out.println("=========Result========");
        System.out.println(result);
        return result;
    }
}
