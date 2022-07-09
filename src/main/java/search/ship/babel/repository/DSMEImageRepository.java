package search.ship.babel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import search.ship.babel.domain.DSMEImage;

import java.util.List;
import java.util.Optional;

public interface DSMEImageRepository extends JpaRepository<DSMEImage, String> {
    Optional<DSMEImage> findByDSMECode(String DSMECode);
    @Query(value = "SELECT d FROM DSMEImage d")
    List<DSMEImage> findByImageCodeAndFile();
}
