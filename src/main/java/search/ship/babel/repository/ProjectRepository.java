package search.ship.babel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import search.ship.babel.domain.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, String> {
    Optional<Project> findByDesignerCode(String designerCode);
    @Query("SELECT p FROM project p")
    List<Project> findByProjectCode();
}
