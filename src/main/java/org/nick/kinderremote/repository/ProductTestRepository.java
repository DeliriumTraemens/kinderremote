package org.nick.kinderremote.repository;

import org.nick.kinderremote.data.entity.test.ProductTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductTestRepository extends JpaRepository<ProductTest, Integer>, JpaSpecificationExecutor<ProductTest> {

}