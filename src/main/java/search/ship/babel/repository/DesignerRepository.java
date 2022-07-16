package search.ship.babel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import search.ship.babel.domain.Designer;

import java.util.Optional;

public interface DesignerRepository extends JpaRepository<Designer, String> {
    Optional<Designer> findByDesignerName(String designerName);

    Optional<Designer> findByDesignerCode(String designerCode);
}
