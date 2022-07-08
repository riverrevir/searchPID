package search.ship.babel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import search.ship.babel.domain.Project;
import search.ship.babel.dto.project.ProjectListResponse;
import search.ship.babel.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectListService {
    private final ProjectRepository projectRepository;

    public List<ProjectListResponse> getByProjectList(){
        List<Project> projects=projectRepository.findByProjectCode();
        List<ProjectListResponse> projectListResponses=new ArrayList<>();
        projects.forEach(project -> {
            ProjectListResponse projectListResponse=ProjectListResponse.from(project);
            projectListResponses.add(projectListResponse);
        });
        return projectListResponses;
    }
}
