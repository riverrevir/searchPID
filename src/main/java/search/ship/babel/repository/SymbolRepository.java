package search.ship.babel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import search.ship.babel.domain.Symbol;

import java.util.List;

public interface SymbolRepository extends JpaRepository<Symbol, Long> {
    List<Symbol> findBySymbolDesigner(String designer);

    @Query(value = "SELECT DISTINCT s.symbolDesigner FROM symbol s")
    List<String> findDistinctSymbolDesigner();
}
