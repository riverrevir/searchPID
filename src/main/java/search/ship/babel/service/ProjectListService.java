package search.ship.babel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import search.ship.babel.domain.Designer;
import search.ship.babel.domain.Project;
import search.ship.babel.dto.designer.DesignerProjectListResponse;
import search.ship.babel.dto.project.ProjectListResponse;
import search.ship.babel.repository.DesignerRepository;
import search.ship.babel.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectListService {
    private final ProjectRepository projectRepository;
    private final DesignerRepository designerRepository;

    @Transactional(readOnly = true)
    public List<DesignerProjectListResponse> getByProjectList(String designerName){
        Designer designer=designerRepository.findByDesignerName(designerName).orElseThrow(()->new IllegalArgumentException("해당 디자이너 이름이 없습니다."));
        List<String> projects=projectRepository.findByProjectName(designer.getDesignerCode());
        List<DesignerProjectListResponse> designerProjectListResponses=new ArrayList<>();
        return projects.stream().map(DesignerProjectListResponse::from).collect(Collectors.toList());
    }
}
