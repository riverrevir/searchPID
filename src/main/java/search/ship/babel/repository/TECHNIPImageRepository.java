package search.ship.babel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import search.ship.babel.domain.TECHNIPImage;

import java.util.List;
import java.util.Optional;

public interface TECHNIPImageRepository extends JpaRepository<TECHNIPImage, String> {
    Optional<TECHNIPImage> findByTECHNIPCode(String TECHNIPCode);

    @Query(value = "SELECT t FROM TECHNIPImage t")
    List<TECHNIPImage> findByImageCodeAndFile();

    List<TECHNIPImage> findBySymbolCode(String symbolCode);
}
