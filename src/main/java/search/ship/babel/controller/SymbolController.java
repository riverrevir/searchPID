package search.ship.babel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import search.ship.babel.dto.list.DesignerListResponse;
import search.ship.babel.dto.project.ProjectListResponse;
import search.ship.babel.dto.symbol.SymbolInfoDto;
import search.ship.babel.service.ProjectSymbolService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SymbolController {

    private final ProjectSymbolService projectSymbolService;

    /**
     * 프로젝트 검색
     */
    @GetMapping("/api/project")
    public List<SymbolInfoDto> findProjectByName(@RequestParam String projectName) {
        return projectSymbolService.findByProjectName(projectName);
    }

    /**
     * 설계사 검색
     */
    @GetMapping("/api/designer")
    public List<SymbolInfoDto> findDesigner(@RequestParam String designer) {
        return projectSymbolService.findByDesigner(designer);
    }

    /**
     * 설계사 리스트 호출
     */
    @GetMapping("/api/list/designer")
    public DesignerListResponse getByDesignerList() {
        return projectSymbolService.getByDesigner();
    }

    /**
     * 프로젝트 리스트 호출
     */
    @GetMapping("/api/list/project")
    public ProjectListResponse getByProjectList() {
        return projectSymbolService.getByProject();
    }
}
