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
    private String label;
    private String shape;

    public static DesignerImageListResponse from(AKERImage akerImage, Classification classification, Symbol symbol) {
        return DesignerImageListResponse.builder()
                .imageCode(akerImage.getAKERCode())
                .classificationName(classification.getClassificationName())
                .symbolName(symbol.getSymbolName())
                .file(akerImage.getAKERFile())
                .label(akerImage.getLabel())
                .shape(akerImage.getShape())
                .build();
    }

    public static DesignerImageListResponse from(DSMEImage dsmeImage, Classification classification, Symbol symbol) {
        return DesignerImageListResponse.builder()
                .imageCode(dsmeImage.getDSMECode())
                .classificationName(classification.getClassificationName())
                .symbolName(symbol.getSymbolName())
                .file(dsmeImage.getDSMEFile())
                .label(dsmeImage.getLabel())
                .shape(dsmeImage.getShape())
                .build();
    }

    public static DesignerImageListResponse from(KBRImage kbrImage, Classification classification, Symbol symbol) {
        return DesignerImageListResponse.builder()
                .imageCode(kbrImage.getKBRCode())
                .classificationName(classification.getClassificationName())
                .symbolName(symbol.getSymbolName())
                .file(kbrImage.getKBRFile())
                .label(kbrImage.getLabel())
                .shape(kbrImage.getShape())
                .build();
    }

    public static DesignerImageListResponse from(TECHNIPImage technipImage, Classification classification, Symbol symbol) {
        return DesignerImageListResponse.builder()
                .imageCode(technipImage.getTECHNIPCode())
                .classificationName(classification.getClassificationName())
                .symbolName(symbol.getSymbolName())
                .file(technipImage.getTECHNIPFile())
                .label(technipImage.getLabel())
                .shape(technipImage.getShape())
                .build();
    }
}
