package org.nick.kinderremote.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.nick.kinderremote.data.dto.AuthorisationDto;
import org.nick.kinderremote.data.entity.authorithy.Customer;
import org.nick.kinderremote.data.entity.authorithy.Session;
import org.nick.kinderremote.repository.CustomerRepository;
import org.nick.kinderremote.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Service
public class AuthenticationService {
    private final SessionRepository sesRepo;
    private final CustomerRepository custRepo;
    private final SessionService sesService;
    private final CustomerService custService;

    @Autowired
    public AuthenticationService(SessionRepository sesRepo, CustomerRepository custRepo, SessionService sesService, CustomerService custService) {
        this.sesRepo = sesRepo;
        this.custRepo = custRepo;
        this.sesService = sesService;
        this.custService = custService;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
    }

//    public Session createNewSession(String uuid) {
//
//        return null;
//    }

    /* Добавить в сущность флаг обращения к сущности - если флаг отрицательный,
    можно создать Покупателя, если положительный, то можно искать покупателя.
    Так же можно в сущность сессии добавить айди Кастомера
    fd665177-29dd-4e27-9940-02fc92438bcd*/

    public String processing(String sessionId, HttpServletRequest request) {
//        String s1 = custRepo.findById(95L).toString();
        String s = sesRepo.readByUuid(sessionId).toString();
//        System.out.println("CHECK==="+obj);

        return s;
    }

    public String processAuthorisation(String sessionId, HttpServletRequest request) {
//        Session newSession = new Session();
//        ПРОРАБОТАТЬ ЛОГИКУ ЗАПРОСА если сессия существует
        if (sesService.chekIsExistedSession(sessionId) == true) {
            Customer customer = custService.retrieveCustomer(sessionId);
//            return "Session exists:\n"+sesRepo.findByUuid(sessionId).toString();

            return customer.toString();

        } else {
            return createNewSession(sessionId);
        }
//        newSession=sesRepo.findByUuid(sessionId);
    }

    public String createNewSession(String sessionId) {
        Session newSession = sesService.createNewSession(sessionId);
        Customer newCustomer = custService.createNewAnonimousCustomer(newSession);
        newSession.setCustomer(newCustomer);
        sesRepo.save(newSession);
        AuthorisationDto forSend = new AuthorisationDto();
        forSend.setUsername(newCustomer.getFirstname());
        forSend.setSessionId(sessionId);
        forSend.setCreatedAt(LocalDateTime.now());
        forSend.setToken(newCustomer.getFirstname() + sessionId);
//Create Dto for send out
        Gson gson = new Gson();
        String result = gson.toJson(forSend);

        System.out.println("=========Result========");
        System.out.println(result);
        return result;
    }
}
