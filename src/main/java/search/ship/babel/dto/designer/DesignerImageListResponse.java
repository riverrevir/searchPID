package search.ship.babel.dto.designer;

import lombok.Builder;
import lombok.Getter;
import search.ship.babel.domain.*;

@Getter
@Builder
public class DesignerImageListResponse {
    private String imageCode;
    private String classificationName;
    private String symbolName;
    private String file;

    public static DesignerImageListResponse from(AKERImage akerImage, Classification classification, Symbol symbol) {
        return DesignerImageListResponse.builder()
                .imageCode(akerImage.getAKERCode())
                .classificationName(classification.getClassificationName())
                .symbolName(symbol.getSymbolName())
                .file(akerImage.getAKERFile())
                .build();
    }

    public static DesignerImageListResponse from(DSMEImage dsmeImage, Classification classification, Symbol symbol) {
        return DesignerImageListResponse.builder()
                .imageCode(dsmeImage.getDSMECode())
                .classificationName(classification.getClassificationName())
                .symbolName(symbol.getSymbolName())
                .file(dsmeImage.getDSMEFile())
                .build();
    }

    public static DesignerImageListResponse from(KBRImage kbrImage, Classification classification, Symbol symbol) {
        return DesignerImageListResponse.builder()
                .imageCode(kbrImage.getKBRCode())
                .classificationName(classification.getClassificationName())
                .symbolName(symbol.getSymbolName())
                .file(kbrImage.getKBRFile())
                .build();
    }

    public static DesignerImageListResponse from(TECHNIPImage technipImage, Classification classification, Symbol symbol) {
        return DesignerImageListResponse.builder()
                .imageCode(technipImage.getTECHNIPCode())
                .classificationName(classification.getClassificationName())
                .symbolName(symbol.getSymbolName())
                .file(technipImage.getTECHNIPFile())
                .build();
    }
}
