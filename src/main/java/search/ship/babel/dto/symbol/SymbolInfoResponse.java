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

    public static SymbolInfoResponse from(Classification classification, Symbol symbol, String designerName, DSMEImage dsmeImage){
        return SymbolInfoResponse.builder()
                .classificationName(classification.getClassificationName())
                .symbolName(symbol.getSymbolName())
                .symbolCode(symbol.getSymbolCode())
                .designerName(designerName)
                .file(dsmeImage.getDSMEFile())
                .build();
    }

    public static SymbolInfoResponse from(Classification classification, Symbol symbol, String designerName, AKERImage akerImage){
        return SymbolInfoResponse.builder()
                .classificationName(classification.getClassificationName())
                .symbolName(symbol.getSymbolName())
                .symbolCode(symbol.getSymbolCode())
                .designerName(designerName)
                .file(akerImage.getAKERFile())
                .build();
    }

    public static SymbolInfoResponse from(Classification classification, Symbol symbol, String designerName, KBRImage kbrImage){
        return SymbolInfoResponse.builder()
                .classificationName(classification.getClassificationName())
                .symbolName(symbol.getSymbolName())
                .symbolCode(symbol.getSymbolCode())
                .designerName(designerName)
                .file(kbrImage.getKBRFile())
                .build();
    }

    public static SymbolInfoResponse from(Classification classification, Symbol symbol, String designerName, TECHNIPImage technipImage){
        return SymbolInfoResponse.builder()
                .classificationName(classification.getClassificationName())
                .symbolName(symbol.getSymbolName())
                .symbolCode(symbol.getSymbolCode())
                .designerName(designerName)
                .file(technipImage.getTECHNIPFile())
                .build();
    }

}
