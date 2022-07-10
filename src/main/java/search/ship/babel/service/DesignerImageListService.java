package search.ship.babel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import search.ship.babel.domain.*;
import search.ship.babel.dto.designer.DesignerImageListResponse;
import search.ship.babel.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
@Transactional
public class DesignerImageListService {

    private final AKERImageRepository akerImageRepository;
    private final DSMEImageRepository dsmeImageRepository;
    private final KBRImageRepository kbrImageRepository;
    private final TECHNIPImageRepository technipImageRepository;
    private final ClassificationRepository classificationRepository;
    private final SymbolRepository symbolRepository;

    @Transactional(readOnly = true)
    public List<DesignerImageListResponse> getDesignerImageListByDesignerName(String designerName) {
        List<DesignerImageListResponse> designerImageListResponses = new ArrayList<>();
        final String designerNameLower = designerName.toLowerCase();
        if (designerNameLower.equals("aker")) {
            List<AKERImage> akerImages = akerImageRepository.findByImageCodeAndFile();
            akerImages.forEach(akerImage -> {
                String[] codeSplit = akerImage.getAKERCode().split("-");
                Classification classification = classificationRepository.findByClassificationCode(codeSplit[0]).orElseThrow(() -> new IllegalArgumentException("해당하는 분류가 없습니다."));
                Symbol symbol = symbolRepository.findBySymbolCode(codeSplit[0] + "-" + codeSplit[1]).orElseThrow(() -> new IllegalArgumentException("해당하는 심볼이 없습니다."));
                DesignerImageListResponse designerImageListResponse = DesignerImageListResponse.from(akerImage, classification, symbol);
                designerImageListResponses.add(designerImageListResponse);
            });

        } else if (designerNameLower.equals("dsme")) {
            List<DSMEImage> dsmeImages = dsmeImageRepository.findByImageCodeAndFile();
            dsmeImages.forEach(dsmeImage -> {
                String[] codeSplit = dsmeImage.getDSMECode().split("-");
                Classification classification = classificationRepository.findByClassificationCode(codeSplit[0]).orElseThrow(() -> new IllegalArgumentException("해당하는 분류가 없습니다."));
                Symbol symbol = symbolRepository.findBySymbolCode(codeSplit[0] + "-" + codeSplit[1]).orElseThrow(() -> new IllegalArgumentException("해당하는 심볼이 없습니다."));
                DesignerImageListResponse designerImageListResponse = DesignerImageListResponse.from(dsmeImage, classification, symbol);
                designerImageListResponses.add(designerImageListResponse);
            });

        } else if (designerNameLower.equals("kbr")) {
            List<KBRImage> kbrImages = kbrImageRepository.findByImageCodeAndFile();
            kbrImages.forEach(kbrImage -> {
                String[] codeSplit = kbrImage.getKBRCode().split("-");
                Classification classification = classificationRepository.findByClassificationCode(codeSplit[0]).orElseThrow(() -> new IllegalArgumentException("해당하는 분류가 없습니다."));
                Symbol symbol = symbolRepository.findBySymbolCode(codeSplit[0] + "-" + codeSplit[1]).orElseThrow(() -> new IllegalArgumentException("해당하는 심볼이 없습니다."));
                DesignerImageListResponse designerImageListResponse = DesignerImageListResponse.from(kbrImage, classification, symbol);
                designerImageListResponses.add(designerImageListResponse);
            });

        } else if (designerNameLower.equals("technip")) {
            List<TECHNIPImage> technipImages = technipImageRepository.findByImageCodeAndFile();
            technipImages.forEach(technipImage -> {
                String[] codeSplit = technipImage.getTECHNIPCode().split("-");
                Classification classification = classificationRepository.findByClassificationCode(codeSplit[0]).orElseThrow(() -> new IllegalArgumentException("해당하는 분류가 없습니다."));
                Symbol symbol = symbolRepository.findBySymbolCode(codeSplit[0] + "-" + codeSplit[1]).orElseThrow(() -> new IllegalArgumentException("해당하는 심볼이 없습니다."));
                DesignerImageListResponse designerImageListResponse = DesignerImageListResponse.from(technipImage, classification, symbol);
                designerImageListResponses.add(designerImageListResponse);
            });

        }
        return designerImageListResponses;
    }
}
