package search.ship.babel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import search.ship.babel.domain.*;
import search.ship.babel.dto.project.ProjectListResponse;
import search.ship.babel.repository.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ProjectSearchService {

    private final DesignerRepository designerRepository;
    private final ProjectRepository projectRepository;
    private final SymbolRepository symbolRepository;
    private final ClassificationRepository classificationRepository;
    private final AKERImageRepository akerImageRepository;
    private final DSMEImageRepository dsmeImageRepository;
    private final KBRImageRepository kbrImageRepository;
    private final TECHNIPImageRepository technipImageRepository;


    @Transactional(readOnly = true)
    public List<ProjectListResponse> getProjectListByDesigner(String designerName) {
        String designerNameLower = designerName.toLowerCase();
        List<ProjectListResponse> projectListResponses = new ArrayList<>();
        Designer designer = designerRepository.findByDesignerName(designerName).orElseThrow(() -> new IllegalArgumentException("해당 디자이너는 없습니다."));
        final String designerCode = designer.getDesignerCode();
        Project project = projectRepository.findByDesignerCode(designerCode).orElseThrow(() -> new IllegalArgumentException("해당 디자이너 코드는 없습니다."));
        final String projectList = project.getProjectList();
        final String[] projectListSplit = projectList.split(",");

        if (designerNameLower.equals("aker")) {
            for (int i = 0; i < projectListSplit.length; i++) {
                AKERImage akerImage = akerImageRepository.findByAKERCode(projectListSplit[i]).orElseThrow(() -> new IllegalArgumentException("해당 프로젝트의 이미지 코드가 없습니다."));
                final String symbolCode = akerImage.getSymbolCode();
                Symbol symbol = symbolRepository.findBySymbolCode(symbolCode).orElseThrow(() -> new IllegalArgumentException("해당 심볼 코드는 없습니다."));

                final String[] detailProjectSplit = projectListSplit[i].split("-");
                Classification classification = classificationRepository.findByClassificationCode(detailProjectSplit[0]).orElseThrow(() -> new IllegalArgumentException("해당 분류 코드가 없습니다."));
                ProjectListResponse projectListResponse = ProjectListResponse.from(project, designer, classification, symbol, akerImage);
                projectListResponses.add(projectListResponse);
            }
        } else if (designerNameLower.equals("dsme")) {
            for (int i = 0; i < projectListSplit.length; i++) {
                DSMEImage dsmeImage = dsmeImageRepository.findByDSMECode(projectListSplit[i]).orElseThrow(() -> new IllegalArgumentException("해당 프로젝트의 이미지 코드가 없습니다."));
                final String symbolCode = dsmeImage.getSymbolCode();
                Symbol symbol = symbolRepository.findBySymbolCode(symbolCode).orElseThrow(() -> new IllegalArgumentException("해당 심볼 코드는 없습니다."));

                final String[] detailProjectSplit = projectListSplit[i].split("-");
                Classification classification = classificationRepository.findByClassificationCode(detailProjectSplit[0]).orElseThrow(() -> new IllegalArgumentException("해당 분류 코드가 없습니다."));
                ProjectListResponse projectListResponse = ProjectListResponse.from(project, designer, classification, symbol, dsmeImage);
                projectListResponses.add(projectListResponse);
            }
        } else if (designerNameLower.equals("kbr")) {
            for (int i = 0; i < projectListSplit.length; i++) {
                KBRImage kbrImage = kbrImageRepository.findByKBRCode(projectListSplit[i]).orElseThrow(() -> new IllegalArgumentException("해당 프로젝트의 이미지 코드가 없습니다."));
                final String symbolCode = kbrImage.getSymbolCode();
                Symbol symbol = symbolRepository.findBySymbolCode(symbolCode).orElseThrow(() -> new IllegalArgumentException("해당 심볼 코드는 없습니다."));

                final String[] detailProjectSplit = projectListSplit[i].split("-");
                Classification classification = classificationRepository.findByClassificationCode(detailProjectSplit[0]).orElseThrow(() -> new IllegalArgumentException("해당 분류 코드가 없습니다."));
                ProjectListResponse projectListResponse = ProjectListResponse.from(project, designer, classification, symbol, kbrImage);
                projectListResponses.add(projectListResponse);
            }
        } else if (designerNameLower.equals("technip")) {
            for (int i = 0; i < projectListSplit.length; i++) {
                TECHNIPImage technipImage = technipImageRepository.findByTECHNIPCode(projectListSplit[i]).orElseThrow(() -> new IllegalArgumentException("해당 프로젝트의 이미지 코드가 없습니다."));
                final String symbolCode = technipImage.getSymbolCode();
                Symbol symbol = symbolRepository.findBySymbolCode(symbolCode).orElseThrow(() -> new IllegalArgumentException("해당 심볼 코드는 없습니다."));

                final String[] detailProjectSplit = projectListSplit[i].split("-");
                Classification classification = classificationRepository.findByClassificationCode(detailProjectSplit[0]).orElseThrow(() -> new IllegalArgumentException("해당 분류 코드가 없습니다."));
                ProjectListResponse projectListResponse = ProjectListResponse.from(project, designer, classification, symbol, technipImage);
                projectListResponses.add(projectListResponse);
            }
        }
        return projectListResponses;
    }

    @Transactional(readOnly = true)
    public List<ProjectListResponse> getProjectListByProjectCode(String projectCode) {
        List<ProjectListResponse> projectListResponses = new ArrayList<>();
        Project project = projectRepository.findByProjectCode(projectCode).orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재 하지 않습니다."));
        final String designerCode = project.getDesignerCode();
        Designer designer = designerRepository.findByDesignerCode(designerCode).orElseThrow(() -> new IllegalArgumentException("해당 프로젝트의 디자이너가 존재하지 않습니다."));
        final String designerName = designer.getDesignerName().toLowerCase();
        final String[] projectListSplit = project.getProjectList().split(",");
        if (designerName.equals("aker")) {
            for (int i = 0; i < projectListSplit.length; i++) {
                final String[] detailProjectSplit = projectListSplit[i].split("-");
                Classification classification = classificationRepository.findByClassificationCode(detailProjectSplit[0]).orElseThrow(() -> new IllegalArgumentException("해당 분류 코드가 없습니다."));
                Symbol symbol = symbolRepository.findBySymbolCode(detailProjectSplit[0] + "-" + detailProjectSplit[1]).orElseThrow(() -> new IllegalArgumentException("해당 심볼 코드가 없습니다."));
                AKERImage akerImage = akerImageRepository.findByAKERCode(projectListSplit[i]).orElseThrow(() -> new IllegalArgumentException("해당 프로젝트의 이미지 코드가 없습니다."));
                ProjectListResponse projectListResponse = ProjectListResponse.from(project, designer, classification, symbol, akerImage);
                projectListResponses.add(projectListResponse);
            }
        } else if (designerName.equals("dsme")) {
            for (int i = 0; i < projectListSplit.length; i++) {
                final String[] detailProjectSplit = projectListSplit[i].split("-");
                Classification classification = classificationRepository.findByClassificationCode(detailProjectSplit[0]).orElseThrow(() -> new IllegalArgumentException("해당 분류 코드가 없습니다."));
                Symbol symbol = symbolRepository.findBySymbolCode(detailProjectSplit[0] + "-" + detailProjectSplit[1]).orElseThrow(() -> new IllegalArgumentException("해당 심볼 코드가 없습니다."));
                DSMEImage dsmeImage = dsmeImageRepository.findByDSMECode(projectListSplit[i]).orElseThrow(() -> new IllegalArgumentException("해당 프로젝트의 이미지 코드가 없습니다."));
                ProjectListResponse projectListResponse = ProjectListResponse.from(project, designer, classification, symbol, dsmeImage);
                projectListResponses.add(projectListResponse);
            }
        } else if (designerName.equals("kbr")) {
            for (int i = 0; i < projectListSplit.length; i++) {
                final String[] detailProjectSplit = projectListSplit[i].split("-");
                Classification classification = classificationRepository.findByClassificationCode(detailProjectSplit[0]).orElseThrow(() -> new IllegalArgumentException("해당 분류 코드가 없습니다."));
                Symbol symbol = symbolRepository.findBySymbolCode(detailProjectSplit[0] + "-" + detailProjectSplit[1]).orElseThrow(() -> new IllegalArgumentException("해당 심볼 코드가 없습니다."));
                KBRImage kbrImage = kbrImageRepository.findByKBRCode(projectListSplit[i]).orElseThrow(() -> new IllegalArgumentException("해당 프로젝트의 이미지 코드가 없습니다."));
                ProjectListResponse projectListResponse = ProjectListResponse.from(project, designer, classification, symbol, kbrImage);
                projectListResponses.add(projectListResponse);
            }
        } else if (designerName.equals("technip")) {
            for (int i = 0; i < projectListSplit.length; i++) {
                final String[] detailProjectSplit = projectListSplit[i].split("-");
                Classification classification = classificationRepository.findByClassificationCode(detailProjectSplit[0]).orElseThrow(() -> new IllegalArgumentException("해당 분류 코드가 없습니다."));
                Symbol symbol = symbolRepository.findBySymbolCode(detailProjectSplit[0] + "-" + detailProjectSplit[1]).orElseThrow(() -> new IllegalArgumentException("해당 심볼 코드가 없습니다."));
                TECHNIPImage technipImage = technipImageRepository.findByTECHNIPCode(projectListSplit[i]).orElseThrow(() -> new IllegalArgumentException("해당 프로젝트의 이미지 코드가 없습니다."));
                ProjectListResponse projectListResponse = ProjectListResponse.from(project, designer, classification, symbol, technipImage);
                projectListResponses.add(projectListResponse);
            }
        }
        return projectListResponses;
    }
}
