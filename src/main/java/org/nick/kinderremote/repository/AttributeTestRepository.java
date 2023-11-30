package org.nick.kinderremote.repository;

import org.nick.kinderremote.data.entity.test.AttributeTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AttributeTestRepository extends JpaRepository<AttributeTest, Void>, JpaSpecificationExecutor<AttributeTest> {

}