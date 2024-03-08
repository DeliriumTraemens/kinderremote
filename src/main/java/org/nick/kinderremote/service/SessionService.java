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

    public Session findByUuid(String uuid){
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
        Session forChek =  findByUuid(uuid);
        if(forChek == null){
            return false;
        }
        return true;
    }
}
