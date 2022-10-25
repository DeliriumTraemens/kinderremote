package org.nick.kinderremote.repository;

import org.nick.kinderremote.data.entity.Product;
import org.nick.kinderremote.data.projections.ProdCardProjIf;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.catId = :id")
    Page<ProdCardProjIf> findProductsByCatId(@Param("id") Long catId, Pageable pageRequest);

//    @Query(value="SELECT * FROM oc_product p ORDER BY RAND() LIMIT 15", nativeQuery=true)
    @Query(value="SELECT p.product_id as id, p.image, p.price, " +
                " pd.name " +
                "FROM oc_product AS p " +
                "LEFT JOIN oc_product_description AS pd" +
                " ON p.product_id = pd.product_id" +
                " ORDER BY RAND()" +
                " LIMIT 15",
            nativeQuery=true)
    Set<ProdCardProjIf> getInitialProductList();

    @Query(value="SELECT p.product_id as id, p.image, p.price, " +
            " pd.name," +
            "manufacturer.manufacturer_id, manufacturer.name AS name_1 " +
            "FROM oc_product AS p " +
            "LEFT JOIN oc_product_description AS pd" +
            " ON p.product_id = pd.product_id " +
            "LEFT JOIN oc_manufacturer AS manufacturer " +
            "ON p.manufacturer_id = manufacturer.manufacturer_id" +
            " ORDER BY RAND()" +
            " LIMIT 15", nativeQuery=true)
//    @Query(value = "SELECT p.product_id FROM oc_product p  order by RAND()  LIMIT 10  ")
    Set<Object> getInitialProductListWithManufacturer();

    @Query("SELECT p.id FROM Product p")
    Set<Long> getAllProductId();
}
