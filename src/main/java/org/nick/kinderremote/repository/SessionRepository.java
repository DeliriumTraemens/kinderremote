package org.nick.kinderremote.repository;

import org.nick.kinderremote.data.entity.authorithy.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

}
