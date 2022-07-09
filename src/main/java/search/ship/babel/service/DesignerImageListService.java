package search.ship.babel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import search.ship.babel.domain.AKERImage;
import search.ship.babel.domain.DSMEImage;
import search.ship.babel.domain.KBRImage;
import search.ship.babel.dto.designer.DesignerImageListResponse;
import search.ship.babel.repository.AKERImageRepository;
import search.ship.babel.repository.DSMEImageRepository;
import search.ship.babel.repository.KBRImageRepository;
import search.ship.babel.repository.TECHNIPImageRepository;

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

    @Transactional(readOnly = true)
    public List<DesignerImageListResponse> getDesignerImageListByDesignerName(String designerName){
        List<DesignerImageListResponse> designerImageListResponses=new ArrayList<>();
        final String designerNameLower=designerName.toLowerCase();
        if(designerNameLower.equals("aker")){
            List<AKERImage> akerImages=akerImageRepository.findByImageCodeAndFile();
            akerImages.forEach(akerImage -> {
                DesignerImageListResponse designerImageListResponse=DesignerImageListResponse.from(akerImage);
                designerImageListResponses.add(designerImageListResponse);
            });

        }else if(designerNameLower.equals("dsme")){
            List<DSMEImage> dsmeImages=dsmeImageRepository.findByImageCodeAndFile();
            dsmeImages.forEach(dsmeImage -> {
                DesignerImageListResponse designerImageListResponse=DesignerImageListResponse.from(dsmeImage);
                designerImageListResponses.add(designerImageListResponse);
            });

        }else if(designerNameLower.equals("kbr")){
            List<KBRImage> kbrImages=kbrImageRepository.findByImageCodeAndFile();
            kbrImages.forEach(kbrImage-> {
                DesignerImageListResponse designerImageListResponse=DesignerImageListResponse.from(kbrImage);
                designerImageListResponses.add(designerImageListResponse);
            });

        }else if(designerNameLower.equals("technip")){
            List<AKERImage> akerImages=akerImageRepository.findByImageCodeAndFile();
            akerImages.forEach(akerImage -> {
                DesignerImageListResponse designerImageListResponse=DesignerImageListResponse.from(akerImage);
                designerImageListResponses.add(designerImageListResponse);
            });

        }
        return designerImageListResponses;
    }
}
