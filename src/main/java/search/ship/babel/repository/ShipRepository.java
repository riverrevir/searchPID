package search.ship.babel.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import search.ship.babel.domain.QShip;
import search.ship.babel.domain.Ship;

import java.util.List;
import java.util.Optional;

public interface ShipRepository extends JpaRepository<Ship, Long> {

//    public static final String Find_Project="SELECT PName,";
    Optional<Ship> findByPName(String symbol);
    Optional<Ship> findByProject(String project);
}
