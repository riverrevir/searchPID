package search.ship.babel.dto.project;

import lombok.Builder;
import lombok.Getter;
import search.ship.babel.domain.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class ProjectListResponse implements Comparable<ProjectListResponse> {
    private Long projectIndex;
    private String projectCode;
    private String designerName;
    private String classificationName;
    private String symbolName;
    private LocalDateTime projectCreateAt;
    private String file;

    public static ProjectListResponse from(Project project){
        return ProjectListResponse.builder()
                .projectCode(project.getProjectCode())
                .build();
    }
    public static ProjectListResponse from(Project project, Designer designer, Classification classification, Symbol symbol, AKERImage akerImage){
        return ProjectListResponse.builder()
                .projectIndex(project.getProjectIndex())
                .projectCode(project.getProjectCode())
                .projectCreateAt(project.getProjectCreateAt())
                .designerName(designer.getDesignerName())
                .classificationName(classification.getClassificationName())
                .symbolName(symbol.getSymbolName())
                .file(akerImage.getAKERFile())
                .build();
    }
    public static ProjectListResponse from(Project project, Designer designer, Classification classification, Symbol symbol, DSMEImage dsmeImage){
        return ProjectListResponse.builder()
                .projectIndex(project.getProjectIndex())
                .projectCode(project.getProjectCode())
                .projectCreateAt(project.getProjectCreateAt())
                .designerName(designer.getDesignerName())
                .classificationName(classification.getClassificationName())
                .symbolName(symbol.getSymbolName())
                .file(dsmeImage.getDSMEFile())
                .build();
    }
    public static ProjectListResponse from(Project project, Designer designer, Classification classification, Symbol symbol, KBRImage kbrImage){
        return ProjectListResponse.builder()
                .projectIndex(project.getProjectIndex())
                .projectCode(project.getProjectCode())
                .projectCreateAt(project.getProjectCreateAt())
                .designerName(designer.getDesignerName())
                .classificationName(classification.getClassificationName())
                .symbolName(symbol.getSymbolName())
                .file(kbrImage.getKBRFile())
                .build();
    }
    public static ProjectListResponse from(Project project, Designer designer, Classification classification, Symbol symbol, TECHNIPImage technipImage){
        return ProjectListResponse.builder()
                .projectIndex(project.getProjectIndex())
                .projectCode(project.getProjectCode())
                .projectCreateAt(project.getProjectCreateAt())
                .designerName(designer.getDesignerName())
                .classificationName(classification.getClassificationName())
                .symbolName(symbol.getSymbolName())
                .file(technipImage.getTECHNIPFile())
                .build();
    }

    @Override
    public int compareTo(ProjectListResponse projectListResponse) {
        return this.classificationName.compareTo(projectListResponse.classificationName);
    }
}
