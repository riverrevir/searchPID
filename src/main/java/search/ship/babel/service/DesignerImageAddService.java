package search.ship.babel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import search.ship.babel.domain.AKERImage;
import search.ship.babel.domain.DSMEImage;
import search.ship.babel.domain.KBRImage;
import search.ship.babel.domain.TECHNIPImage;
import search.ship.babel.dto.designer.DesignerImageAddRequest;
import search.ship.babel.dto.project.ProjectAddResponse;
import search.ship.babel.repository.AKERImageRepository;
import search.ship.babel.repository.DSMEImageRepository;
import search.ship.babel.repository.KBRImageRepository;
import search.ship.babel.repository.TECHNIPImageRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DesignerImageAddService {
    private final AKERImageRepository akerImageRepository;
    private final DSMEImageRepository dsmeImageRepository;
    private final TECHNIPImageRepository technipImageRepository;
    private final KBRImageRepository kbrImageRepository;

    public ProjectAddResponse designerImageAddByCode(DesignerImageAddRequest request) {
        final String designerName = request.getDesignerName();
        List<String> symbolCode = request.getSymbolCode();
        List<Integer> count = request.getCount();
        if (designerName.equals("dsme")) {
            final int[] indexNumber = {0};
            symbolCode.forEach(s -> {
                final int[] numberCount = {1};
                for (int i = 0; i < count.get(indexNumber[0]); i++) {
                    String imageCode = s + "-" + "0" + String.valueOf(numberCount[0]);
                    String designerNameAndImageCode = designerName + "-" + s + "-" + "0" + String.valueOf(numberCount[0]);
                    DSMEImage dsmeImage = new DSMEImage(imageCode, s, designerNameAndImageCode);
                    dsmeImageRepository.save(dsmeImage);
                    numberCount[0]++;
                }
                indexNumber[0]++;
            });

        } else if (designerName.equals("aker")) {
            final int[] indexNumber = {0};
            symbolCode.forEach(s -> {
                final int[] numberCount = {1};
                for (int i = 0; i < count.get(indexNumber[0]); i++) {
                    String imageCode = s + "-" + "0" + String.valueOf(numberCount[0]);
                    String designerNameAndImageCode = designerName + "-" + s + "-" + "0" + String.valueOf(numberCount[0]);
                    AKERImage akerImage = new AKERImage(imageCode, s, designerNameAndImageCode);
                    akerImageRepository.save(akerImage);
                    numberCount[0]++;
                }
                indexNumber[0]++;
            });

        } else if (designerName.equals("kbr")) {
            final int[] indexNumber = {0};
            symbolCode.forEach(s -> {
                final int[] numberCount = {1};
                for (int i = 0; i < count.get(indexNumber[0]); i++) {
                    String imageCode = s + "-" + "0" + String.valueOf(numberCount[0]);
                    String designerNameAndImageCode = designerName + "-" + s + "-" + "0" + String.valueOf(numberCount[0]);
                    KBRImage kbrImage = new KBRImage(imageCode, s, designerNameAndImageCode);
                    kbrImageRepository.save(kbrImage);
                    numberCount[0]++;
                }
                indexNumber[0]++;
            });

        } else if (designerName.equals("technip")) {
            final int[] indexNumber = {0};
            symbolCode.forEach(s -> {
                final int[] numberCount = {1};
                for (int i = 0; i < count.get(indexNumber[0]); i++) {
                    String imageCode = s + "-" + "0" + String.valueOf(numberCount[0]);
                    String designerNameAndImageCode = designerName + "-" + s + "-" + "0" + String.valueOf(numberCount[0]);
                    TECHNIPImage technipImage = new TECHNIPImage(imageCode, s, designerNameAndImageCode);
                    technipImageRepository.save(technipImage);
                    numberCount[0]++;
                }
                indexNumber[0]++;
            });
        }
        return new ProjectAddResponse("추가완료");
    }
}
