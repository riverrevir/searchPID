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
        String[] projectListSplit = projectList.split(",");

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
        } else if (designerNameLower.equals("te")) {
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
}
