package search.ship.babel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import search.ship.babel.domain.AKERImage;

import java.util.List;
import java.util.Optional;

public interface AKERImageRepository extends JpaRepository<AKERImage, String> {
    Optional<AKERImage> findByAKERCode(String AKERCode);
    @Query(value = "SELECT a FROM AKERImage a")
    List<AKERImage> findByImageCodeAndFile();

    List<AKERImage> findBySymbolCode(String symbolCode);
}
