package search.ship.babel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import search.ship.babel.domain.KBRImage;

import java.util.Optional;

public interface KBRImageRepository extends JpaRepository<KBRImage, String> {
    Optional<KBRImage> findByKBRCode(String KBRCode);
}
