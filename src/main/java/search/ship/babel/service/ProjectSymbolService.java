package search.ship.babel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import search.ship.babel.domain.Project;
import search.ship.babel.domain.ProjectSymbol;
import search.ship.babel.domain.Symbol;
import search.ship.babel.dto.list.DesignerListResponse;
import search.ship.babel.dto.project.ProjectListResponse;
import search.ship.babel.dto.symbol.SymbolInfoDto;
import search.ship.babel.dto.symbol.SymbolSearchRequest;
import search.ship.babel.repository.ProjectRepository;
import search.ship.babel.repository.ProjectSymbolRepository;
import search.ship.babel.repository.SymbolRepository;
import search.ship.babel.repository.SymbolRepositorySupport;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class ProjectSymbolService {
    private final ProjectSymbolRepository projectSymbolRepository;
    private final ProjectRepository projectRepository;

    private final SymbolRepository symbolRepository;
    private final SymbolRepositorySupport symbolRepositorySupport;

    @Transactional(readOnly = true)
    public List<SymbolInfoDto> findByProjectName(String projectName) {
        Project project = projectRepository.findByProjectName(projectName).orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 없습니다."));
        List<ProjectSymbol> projectSymbols = projectSymbolRepository.findProjectSymbolByProjectProjectNumber(project.getProjectNumber());
        return projectSymbols.stream()
                .map(projectSymbol -> SymbolInfoDto.from(projectName, projectSymbol.getSymbol()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<SymbolInfoDto> findByDesigner(String designer) {
        List<Symbol> symbols = symbolRepository.findBySymbolDesigner(designer);
        List<SymbolInfoDto> symbolInfoDtos = new ArrayList<>();
        symbols.forEach(symbol -> {
            List<ProjectSymbol> projectSymbols = projectSymbolRepository.findProjectSymbolBySymbolSymbolNumber(symbol.getSymbolNumber());
            projectSymbols.forEach(projectSymbol -> {
                String projectName = projectSymbol.getProject().getProjectName();
                SymbolInfoDto symbolInfoDto = SymbolInfoDto.from(projectName, symbol);
                symbolInfoDtos.add(symbolInfoDto);
            });
        });
        return symbolInfoDtos;
    }

    @Transactional(readOnly = true)
    public DesignerListResponse getByDesigner() {
        List<String> symbols = symbolRepository.findDistinctSymbolDesigner();
        return new DesignerListResponse(symbols);
    }

    @Transactional(readOnly = true)
    public ProjectListResponse getByProject() {
        List<Project> projects = projectRepository.findByProjectName();
        List<String> responses = projects.stream()
                .map(project -> project.getProjectName())
                .collect(Collectors.toList());
        return new ProjectListResponse(responses);
    }

    @Transactional(readOnly = true)
    public List<SymbolInfoDto> getByCategory(SymbolSearchRequest request){
        final String category=request.getCategory();
        final String symbolName= request.getSymbolName();
        final String designer= request.getDesigner();
        List<Symbol> symbols= symbolRepositorySupport.findAllByCategory(category,symbolName,designer);
        List<SymbolInfoDto> symbolInfoDtos=new ArrayList<>();
        symbols.forEach(symbol -> {
            SymbolInfoDto symbolInfoDto=SymbolInfoDto.from(symbol);
            symbolInfoDtos.add(symbolInfoDto);
        });
        return symbolInfoDtos;
    }
}
