package search.ship.babel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import search.ship.babel.domain.TECHNIPImage;

import java.util.Optional;

public interface TECHNIPImageRepository extends JpaRepository<TECHNIPImage, String> {
    Optional<TECHNIPImage> findByTECHNIPCode(String TECHNIPCode);
}
