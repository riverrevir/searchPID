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
    private String symbolCode;
    private LocalDateTime projectCreateAt;
    private String imageCode;
    private String file;
    private String label;
    private String shape;
    private int order;

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
                .symbolCode(symbol.getSymbolCode())
                .file(akerImage.getAKERFile())
                .imageCode(akerImage.getAKERCode())
                .label(akerImage.getLabel())
                .shape(akerImage.getShape())
                .order(akerImage.getSortingOrder())
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
                .symbolCode(symbol.getSymbolCode())
                .file(dsmeImage.getDSMEFile())
                .imageCode(dsmeImage.getDSMECode())
                .label(dsmeImage.getLabel())
                .shape(dsmeImage.getShape())
                .order(dsmeImage.getSortingOrder())
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
                .symbolCode(symbol.getSymbolCode())
                .file(kbrImage.getKBRFile())
                .imageCode(kbrImage.getKBRCode())
                .label(kbrImage.getLabel())
                .shape(kbrImage.getShape())
                .order(kbrImage.getSortingOrder())
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
                .symbolCode(symbol.getSymbolCode())
                .file(technipImage.getTECHNIPFile())
                .imageCode(technipImage.getTECHNIPCode())
                .label(technipImage.getLabel())
                .shape(technipImage.getShape())
                .order(technipImage.getSortingOrder())
                .build();
    }

    @Override
    public int compareTo(ProjectListResponse projectListResponse) {
        return this.classificationName.compareTo(projectListResponse.classificationName);
    }
}
