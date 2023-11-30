package org.nick.kinderremote.repository;

import org.nick.kinderremote.data.entity.test.AttributeGroupTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AttributeGroupTestRepository extends JpaRepository<AttributeGroupTest, Integer>, JpaSpecificationExecutor<AttributeGroupTest> {

}