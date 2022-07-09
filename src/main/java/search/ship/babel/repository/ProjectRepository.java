package search.ship.babel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import search.ship.babel.domain.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByDesignerCode(String designerCode);

    @Query("SELECT DISTINCT p.projectCode FROM project p " +
            "WHERE designerCode = :designerCode")
    List<String> findByProjectName(@Param("designerCode") String designerCode);

    Optional<Project> findByProjectCode(String projectCode);

    List<Project> findByProjectCodeAndDesignerCode(String projectCode,String designerCode);

    List<Project> findAll();
}
