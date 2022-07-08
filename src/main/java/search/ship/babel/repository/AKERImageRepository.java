package search.ship.babel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import search.ship.babel.domain.AKERImage;

import java.util.Optional;

public interface AKERImageRepository extends JpaRepository<AKERImage, String> {
    Optional<AKERImage> findByAKERCode(String AKERCode);
}
