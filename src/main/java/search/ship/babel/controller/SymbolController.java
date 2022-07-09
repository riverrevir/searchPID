package search.ship.babel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import search.ship.babel.dto.designer.DesignerImageListResponse;
import search.ship.babel.dto.project.ProjectListResponse;
import search.ship.babel.service.DesignerImageListService;
import search.ship.babel.service.ProjectListService;
import search.ship.babel.service.ProjectSearchService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SymbolController {
    private final ProjectSearchService projectSearchService;
    private final ProjectListService projectListService;
    private final DesignerImageListService designerImageListService;
    /**
     * 디자이너로 프로젝트 검색
     */
    @GetMapping(value = "/api/designer")
    public List<ProjectListResponse> getProjectByDesigner(@RequestParam String designerName) {
        return projectSearchService.getProjectListByDesigner(designerName);
    }

    /**
     * 해당 디자이너의 이미지 보여주기
     * @param designerName
     * @return
     */
    @GetMapping(value = "/api/designer/image")
    public List<DesignerImageListResponse> getDesignerImageByDesignerName(@RequestParam String designerName){
        return designerImageListService.getDesignerImageListByDesignerName(designerName);
    }
    /**
     * 프로젝트 리스트 호출
     */
    @GetMapping(value = "/api/project/list")
    public List<ProjectListResponse> getProjectList() {
        return projectListService.getByProjectList();
    }

    /**
     * 프로젝트 검색
     */
    @GetMapping(value = "/api/project")
    public List<ProjectListResponse> getProjectByProjectCode(@RequestParam String projectCode) {
        return projectSearchService.getProjectListByProjectCode(projectCode);
    }
}