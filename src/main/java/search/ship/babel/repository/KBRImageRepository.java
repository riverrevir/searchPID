package search.ship.babel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import search.ship.babel.domain.KBRImage;

import java.util.List;
import java.util.Optional;

public interface KBRImageRepository extends JpaRepository<KBRImage, String> {
    Optional<KBRImage> findByKBRCode(String KBRCode);

    @Query(value = "SELECT k FROM KBRImage k")
    List<KBRImage> findByImageCodeAndFile();

    List<KBRImage> findBySymbolCode(String symbolCode);
}
