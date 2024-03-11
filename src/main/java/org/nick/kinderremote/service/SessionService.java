package org.nick.kinderremote.service;

import org.nick.kinderremote.data.entity.authorithy.Session;
import org.nick.kinderremote.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SessionService {
private final SessionRepository sesRepo;

    public SessionService(SessionRepository sesRepo) {
        this.sesRepo = sesRepo;
    }

    public Session getByUuid(String uuid){
        System.out.println("SessionService.getByUuid\n"+sesRepo.findByUuid(uuid));
        return sesRepo.findByUuid(uuid);
    }

    public Session createNewSession(String uuid){
        Session forCreate = new Session();
        forCreate.setUuid(uuid);
        forCreate.setCreationDate(LocalDateTime.now());
        forCreate.setVisited(true);

        return sesRepo.save(forCreate);
    }

    public Boolean chekIsExistedSession(String uuid){
        Session forChek =  getByUuid(uuid);
        if(forChek == null){
            System.out.println("===============FORCHECK=============== "+forChek);
            return false;
        }
            System.out.println("===============FORCHECK=============== "+forChek);
        return true;
    }
}
