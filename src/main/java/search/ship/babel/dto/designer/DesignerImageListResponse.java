package search.ship.babel.dto.designer;

import lombok.Builder;
import lombok.Getter;
import search.ship.babel.domain.AKERImage;
import search.ship.babel.domain.DSMEImage;
import search.ship.babel.domain.KBRImage;
import search.ship.babel.domain.TECHNIPImage;

@Getter
@Builder
public class DesignerImageListResponse {
    private String imageCode;
    private String file;

    public static DesignerImageListResponse from(AKERImage akerImage){
        return DesignerImageListResponse.builder()
                .imageCode(akerImage.getAKERCode())
                .file(akerImage.getAKERFile())
                .build();
    }
    public static DesignerImageListResponse from(DSMEImage dsmeImage){
        return DesignerImageListResponse.builder()
                .imageCode(dsmeImage.getDSMECode())
                .file(dsmeImage.getDSMEFile())
                .build();
    }
    public static DesignerImageListResponse from(KBRImage kbrImage){
        return DesignerImageListResponse.builder()
                .imageCode(kbrImage.getKBRCode())
                .file(kbrImage.getKBRFile())
                .build();
    }
    public static DesignerImageListResponse from(TECHNIPImage technipImage){
        return DesignerImageListResponse.builder()
                .imageCode(technipImage.getTECHNIPCode())
                .file(technipImage.getTECHNIPFile())
                .build();
    }
}
