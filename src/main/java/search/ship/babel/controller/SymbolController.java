package search.ship.babel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import search.ship.babel.dto.symbol.SymbolInfoDto;
import search.ship.babel.service.ProjectSymbolService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SymbolController {

    private final ProjectSymbolService projectSymbolService;

    @GetMapping("/api/project")
    public List<SymbolInfoDto> findProjectByName(@RequestParam String projectName) {
        return projectSymbolService.findByProjectName(projectName);
    }

    @GetMapping("/api/designer")
    public List<SymbolInfoDto> findDesigner(@RequestParam String designer) {
        return projectSymbolService.findByDesigner(designer);
    }
}
