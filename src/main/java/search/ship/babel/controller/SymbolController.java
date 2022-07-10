package search.ship.babel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import search.ship.babel.dto.designer.DesignerImageListResponse;
import search.ship.babel.dto.designer.DesignerProjectListResponse;
import search.ship.babel.dto.project.ProjectAddRequest;
import search.ship.babel.dto.project.ProjectAddResponse;
import search.ship.babel.dto.project.ProjectListResponse;
import search.ship.babel.dto.symbol.SymbolInfoResponse;
import search.ship.babel.service.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class SymbolController {
    private final ProjectSearchService projectSearchService;
    private final ProjectListService projectListService;
    private final DesignerImageListService designerImageListService;
    private final ProjectAddService projectAddService;
    private final SymbolSearchService symbolSearchService;

    /**
     * 프로젝트 리스트 검색
     */
    @GetMapping(value = "/api/project/detail")
    public List<ProjectListResponse> getProject(@RequestParam String designerName, String projectCode) {
        if (designerName.equals("") && projectCode.equals("")) {
            return projectSearchService.getAllProjectList().stream().sorted().collect(Collectors.toList());
        } else if (!designerName.equals("") && projectCode.equals("")) {
            return projectSearchService.getProjectListByDesigner(designerName).stream().sorted().collect(Collectors.toList());
        } else if (!designerName.equals("") && !projectCode.equals("")) {
            return projectSearchService.getProjectListByDesignerAndProjectCode(designerName, projectCode).stream().sorted().collect(Collectors.toList());
        }
        return null;
    }

    /**
     * 해당 디자이너의 이미지 보여주기
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
    @PostMapping(value = "/api/project/add")
    public ResponseEntity<ProjectAddResponse> addProject(@Validated @RequestBody ProjectAddRequest request) {
        return new ResponseEntity<>(projectAddService.projectAdd(request), HttpStatus.OK);
    }

    /**
     * 심볼 검색
     */
    @GetMapping(value = "/api/symbol")
    public List<SymbolInfoResponse> getSymbolData(@RequestParam String classificationName,String symbolName,String designerName){
        if(!classificationName.equals("")&&symbolName.equals("")&&designerName.equals("")){
            return symbolSearchService.getListByClassification(classificationName);
        } else if(!classificationName.equals("")&&!symbolName.equals("")&&designerName.equals("")){
            return symbolSearchService.getListByClassificationAndSymbolName(classificationName,symbolName);
        }
        return null;
    }
}
