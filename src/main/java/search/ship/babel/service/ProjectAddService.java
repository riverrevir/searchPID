package search.ship.babel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import search.ship.babel.domain.Designer;
import search.ship.babel.domain.Project;
import search.ship.babel.dto.project.ProjectAddRequest;
import search.ship.babel.dto.project.ProjectAddResponse;
import search.ship.babel.repository.DesignerRepository;
import search.ship.babel.repository.ProjectRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectAddService {
    private final ProjectRepository projectRepository;
    private final DesignerRepository designerRepository;

    public ProjectAddResponse projectAdd(ProjectAddRequest request) {
        Designer designer = designerRepository.findByDesignerName(request.getDesignerName()).orElseThrow(() -> new IllegalArgumentException("해당 디자이너는 존재하지 않습니다."));
        Project project=projectRepository.findList(request.getProjectCode(), designer.getDesignerCode(), request.getCurrentSymbolList()).orElseGet(Project::new);
        project.setProjectCode(request.getProjectCode());
        project.setDesignerCode(designer.getDesignerCode());
        project.setSymbolList(request.getSymbolList());
        projectRepository.save(project);
        return new ProjectAddResponse("프로젝트가 추가 되었습니다.");
    }
}
