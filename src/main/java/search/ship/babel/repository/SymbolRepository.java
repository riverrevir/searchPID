package search.ship.babel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import search.ship.babel.domain.Symbol;

import java.util.List;
import java.util.Optional;

public interface SymbolRepository extends JpaRepository<Symbol, String> {
    Optional<Symbol> findBySymbolCode(String symbolCode);
}
