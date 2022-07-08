package search.ship.babel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import search.ship.babel.domain.DSMEImage;

import java.util.Optional;

public interface DSMEImageRepository extends JpaRepository<DSMEImage, String> {
    Optional<DSMEImage> findByDSMECode(String DSMECode);

}
