package org.nick.kinderremote.repository;

import org.nick.kinderremote.data.entity.Manufacturer;
import org.nick.kinderremote.data.entity.Product;
import org.nick.kinderremote.data.projections.ProdCardManIf;
import org.nick.kinderremote.data.projections.ProdCardProjIf;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
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

    @Query(value="SELECT p.product_id as id, p.image as image, p.price as price, " +
            " pd.name as name," +
            "m.manufacturer_id as manId, m.name AS manName, m.image AS manImage " +
            "FROM oc_product p " +
            "LEFT JOIN oc_product_description pd" +
            "   ON p.product_id = pd.product_id " +
            "LEFT JOIN oc_manufacturer m " +
            "   ON p.manufacturer_id = m.manufacturer_id " +
            "ORDER BY RAND() " +
            "LIMIT 15", nativeQuery=true)
//    @Query(value = "SELECT p.product_id FROM oc_product p  order by RAND()  LIMIT 10  ")
    Set<ProdCardManIf> getInitialProductListWithManufacturer();
//    Set<Object[]> getInitialProductListWithManufacturer();

//==Select Products By Manufacturer INSERT JOIN ProductToCategory
    @Query(value="SELECT p.product_id as id, p.image as image, p.price as price, " +
            " pd.name as name, " +
            "m.manufacturer_id as manId, m.name AS manName, m.image AS manImage " +
            "FROM oc_product p " +
            "LEFT JOIN oc_product_description pd" +
            "   ON p.product_id = pd.product_id " +
            "LEFT JOIN oc_product_to_category pc" +
            "   ON p.product_id = pc.product_id " +
            "LEFT JOIN oc_manufacturer m " +
            "   ON p.manufacturer_id = m.manufacturer_id " +
            "WHERE p.manufacturer_id = :manId AND pc.category_id = :catId" +
            " LIMIT 10" , nativeQuery=true)
     Set<ProdCardManIf> getProductListByManufacturer(@Param ("manId")Long manId, @Param("catId")Long catId);

    @Query("SELECT DISTINCT p.id FROM Product p")
    Set<Long> getAllProductId();

    @Query("SELECT DISTINCT p FROM Product p WHERE p.id IN :idList")
    Set<ProdCardProjIf> findRandomProductSet(@Param("idList")List<Long> idList);

    @Query(value= "SELECT p.id FROM Product p ORDER BY RAND() LIMIT 10", nativeQuery=true)
    Set<ProdCardProjIf> findRandomProduct();

//    Set<ProdCardManIf> findDistinctByNameContaining(String searchName);
    Set<Product> findDistinctByNameContaining(String searchName);

    Set<Product> findDistinctByNameContainingAndManufacturerOrderByPriceDesc(String searchName, Manufacturer man);

    @Query(value="SELECT p.name FROM Product p WHERE p.id = :id" ,nativeQuery=true)
    Optional<Product> findById(@Param("id")Long id);
//        List<Product> findById(List<Long> productsIdSearchList);
}
