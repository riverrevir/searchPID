package search.ship.babel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import search.ship.babel.domain.Symbol;

import java.util.List;

public interface SymbolRepository extends JpaRepository<Symbol, Long> {
    List<Symbol> findBySymbolDesigner(String designer);
}
