//package org.nick.kinderremote.repository;
//
//import org.nick.kinderremote.data.entity.Catalog;
//import org.nick.kinderremote.data.projections.CatIdNameViev;
//import org.springframework.data.jpa.repository.EntityGraph;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface CatalogRepo extends JpaRepository<Catalog,Long> {
//    @EntityGraph(attributePaths={"parent"})
//    Optional<Catalog> findById(Long id);
//
//    @Query("Select c from Catalog c where c.id=30")
//    List<CatIdNameViev> buildCatalogView();
//}
