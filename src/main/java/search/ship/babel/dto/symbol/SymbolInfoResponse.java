package search.ship.babel.dto.symbol;

import lombok.Builder;
import lombok.Getter;
import search.ship.babel.domain.*;

@Getter
@Builder
public class SymbolInfoResponse {
    private String classificationName;
    private String symbolName;
    private String symbolCode;
    private String designerName;
    private String file;
    private String imageCode;
    private String label;
    private String shape;
    private Integer order;

    public static SymbolInfoResponse from(Classification classification, Symbol symbol, String designerName, DSMEImage dsmeImage){
        return SymbolInfoResponse.builder()
                .classificationName(classification.getClassificationName())
                .symbolName(symbol.getSymbolName())
                .symbolCode(symbol.getSymbolCode())
                .designerName(designerName)
                .imageCode(dsmeImage.getDSMECode())
                .file(dsmeImage.getDSMEFile())
                .label(dsmeImage.getLabel())
                .shape(dsmeImage.getShape())
                .order(dsmeImage.getSortingOrder())
                .build();
    }

    public static SymbolInfoResponse from(Classification classification, Symbol symbol, String designerName, AKERImage akerImage){
        return SymbolInfoResponse.builder()
                .classificationName(classification.getClassificationName())
                .symbolName(symbol.getSymbolName())
                .symbolCode(symbol.getSymbolCode())
                .designerName(designerName)
                .imageCode(akerImage.getAKERCode())
                .file(akerImage.getAKERFile())
                .label(akerImage.getLabel())
                .shape(akerImage.getShape())
                .order(akerImage.getSortingOrder())
                .build();
    }

    public static SymbolInfoResponse from(Classification classification, Symbol symbol, String designerName, KBRImage kbrImage){
        return SymbolInfoResponse.builder()
                .classificationName(classification.getClassificationName())
                .symbolName(symbol.getSymbolName())
                .symbolCode(symbol.getSymbolCode())
                .designerName(designerName)
                .imageCode(kbrImage.getKBRCode())
                .file(kbrImage.getKBRFile())
                .label(kbrImage.getLabel())
                .shape(kbrImage.getShape())
                .order(kbrImage.getSortingOrder())
                .build();
    }

    public static SymbolInfoResponse from(Classification classification, Symbol symbol, String designerName, TECHNIPImage technipImage){
        return SymbolInfoResponse.builder()
                .classificationName(classification.getClassificationName())
                .symbolName(symbol.getSymbolName())
                .symbolCode(symbol.getSymbolCode())
                .designerName(designerName)
                .imageCode(technipImage.getTECHNIPCode())
                .file(technipImage.getTECHNIPFile())
                .label(technipImage.getLabel())
                .shape(technipImage.getShape())
                .order(technipImage.getSortingOrder())
                .build();
    }

}
