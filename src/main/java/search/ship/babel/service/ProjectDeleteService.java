package search.ship.babel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import search.ship.babel.domain.Designer;
import search.ship.babel.domain.Project;
import search.ship.babel.dto.project.ProjectDeleteResponse;
import search.ship.babel.repository.DesignerRepository;
import search.ship.babel.repository.ProjectRepository;

@Service
@RequiredArgsConstructor
public class ProjectDeleteService {
    private final ProjectRepository projectRepository;
    private final DesignerRepository designerRepository;

    public ProjectDeleteResponse deleteProjectByProjectCodeAndDesignerName(String projectCode,String designerName){
        Designer designer=designerRepository.findByDesignerName(designerName).orElseThrow(()->new IllegalArgumentException("해당 디자이너가 존재하지 않습니다."));
        Project project=projectRepository.findByDesignerCodeAndProjectCode(designer.getDesignerCode(),projectCode).orElseThrow(()->new IllegalArgumentException("해당 프로젝트 코드가 존재하지 않습니다."));
        projectRepository.deleteById(project.getProjectIndex());
        return new ProjectDeleteResponse("해당 프로젝트 삭제가 완료되었습니다.");
    }
}
