package search.ship.babel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import search.ship.babel.domain.Classification;

import java.util.Optional;

public interface ClassificationRepository extends JpaRepository<Classification, String> {
    Optional<Classification> findByClassificationCode(String classificationCode);
}
