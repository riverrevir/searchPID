package search.ship.babel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import search.ship.babel.domain.Ship;

import java.util.Optional;

public interface ShipRepository extends JpaRepository<Ship, Long> {

    public static final String Find_Project="SELECT PName,"
    Optional<Ship> findByPName(String symbol);
    Optional<Ship> findByProject(String project);
}
