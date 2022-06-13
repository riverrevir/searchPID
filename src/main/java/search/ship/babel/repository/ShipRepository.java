package search.ship.babel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
    Page<Ship> findAllByProject(String project, Pageable pageable);
}
