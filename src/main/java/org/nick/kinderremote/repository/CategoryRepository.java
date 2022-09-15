package org.nick.kinderremote.repository;

import org.nick.kinderremote.data.entity.Category;
import org.nick.kinderremote.data.projections.CatalogProjIf;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    //    @EntityGraph(attributePaths={"parent"})
    @Query("Select  c.name   from Category c  where c.id=30")
    List<CatalogProjIf> getCatalog();

//    Optional<CatIdNameViev> findById(Long id);

    List<Category> findAll();

    @Query("select c from Category c where c.id=1125")
    List<CatalogProjIf> bildOtherCatalog();

    @Query("select c from Category c where c.id=:id")
    CatalogProjIf findProjById(@Param("id") Long id);

    @Query("select c from Category c where c.id = :id")
    CatalogProjIf findcatbyid(@Param("id") Long id);
}
