package search.ship.babel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import search.ship.babel.dto.project.ProjectListResponse;
import search.ship.babel.service.ProjectSearchService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProjectController {
    private final ProjectSearchService projectSearchService;

    /**
     * 디자이너로 프로젝트 검색
     */
    @GetMapping(value = "/api/designer")
    public List<ProjectListResponse> getProjectByDesigner(@RequestParam String designerName) {
        System.out.println(designerName);
        return projectSearchService.getProjectListByDesigner(designerName);
    }

}
