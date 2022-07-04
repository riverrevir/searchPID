package search.ship.babel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import search.ship.babel.domain.ProjectSymbol;

import java.util.List;

public interface ProjectSymbolRepository extends JpaRepository<ProjectSymbol, Long> {

    @Query("SELECT ps FROM ProjectSymbol ps " +
            "JOIN ps.project " +
            "JOIN fetch ps.symbol " +
            "WHERE ps.project.projectNumber = :projectNumber")
    List<ProjectSymbol> findProjectSymbolByProjectProjectNumber(Long projectNumber);

    @Query("SELECT ps FROM ProjectSymbol ps " +
            "JOIN ps.symbol " +
            "JOIN fetch ps.project " +
            "WHERE ps.symbol.symbolNumber = :symbolNumber")
    List<ProjectSymbol> findProjectSymbolBySymbolSymbolNumber(Long symbolNumber);
}
