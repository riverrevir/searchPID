package search.ship.babel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import search.ship.babel.dto.designer.DesignerImageListResponse;
import search.ship.babel.dto.designer.DesignerProjectListResponse;
import search.ship.babel.dto.project.ProjectListResponse;
import search.ship.babel.service.DesignerImageListService;
import search.ship.babel.service.ProjectListService;
import search.ship.babel.service.ProjectSearchService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class SymbolController {
    private final ProjectSearchService projectSearchService;
    private final ProjectListService projectListService;
    private final DesignerImageListService designerImageListService;

    /**
     * 프로젝트 리스트 검색
     */
    @GetMapping(value = "/api/project/detail")
    public List<ProjectListResponse> getProject(@RequestParam String designerName,String projectCode){
        if(designerName.equals("")&&projectCode.equals("")) {
            return projectSearchService.getAllProjectList().stream().sorted().collect(Collectors.toList());
        } else if(!designerName.equals("")&&projectCode.equals("")){
            return projectSearchService.getProjectListByDesigner(designerName).stream().sorted().collect(Collectors.toList());
        }else if(!designerName.equals("")&&!projectCode.equals("")){
            return projectSearchService.getProjectListByDesignerAndProjectCode(designerName, projectCode).stream().sorted().collect(Collectors.toList());
        }
        return null;
    }

    /**
     * 수정해야함(response)
     * 해당 디자이너의 이미지 보여주기
     *
     * @param designerName
     * @return
     */
    @GetMapping(value = "/api/designer/image")
    public List<DesignerImageListResponse> getDesignerImageByDesignerName(@RequestParam String designerName) {
        return designerImageListService.getDesignerImageListByDesignerName(designerName);
    }

    /**
     * 프로젝트 리스트 호출(sort 추가 할 예정)
     */
    @GetMapping(value = "/api/project/list")
    public List<DesignerProjectListResponse> getProjectList(@RequestParam String designerName) {
        return projectListService.getByProjectList(designerName);
    }


    /**
     * 프로젝트 추가
     */
//    @PostMapping(value = "/api/project/add")
//    public ProjectAddResponse addProjectByProjectCode(@Validated)
}
