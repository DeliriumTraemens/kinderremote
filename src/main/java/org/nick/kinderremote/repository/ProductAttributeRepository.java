package org.nick.kinderremote.repository;

import org.nick.kinderremote.data.entity.ProductAttributeKey;
import org.nick.kinderremote.data.entity.ProductAttributeMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductAttributeRepository extends JpaRepository<ProductAttributeMain, ProductAttributeKey> {

//    List<ProductAttributeMain> findByKeyProdId(Long key);
@Query("SELECT pa FROM ProductAttributeMain pa WHERE pa.prodId = :productId")
List<ProductAttributeMain> findByKeyProductId(@Param("productId") Long productId);
}
