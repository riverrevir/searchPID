package search.ship.babel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import search.ship.babel.domain.Ship;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    @Query(
            value = "SELECT s FROM ship s" +
                    " WHERE s.project = :project",
            countQuery = "SELECT count(s) FROM ship s" +
                    " WHERE s.project = :project"
    )
    Page<Ship> findAllByProject(@Param("project") String project, Pageable pageable);

    @Query(
            value = "SELECT s FROM ship s" +
                    " WHERE s.subCategory = :subCategory",
            countQuery = "SELECT count(s) FROM ship s" +
                    " WHERE s.subCategory = :subCategory"
    )
    Page<Ship> findBySubCategory(@Param("subCategory") String subcategory, Pageable pageable);
}
