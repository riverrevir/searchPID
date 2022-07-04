package search.ship.babel.dto.symbol;

import lombok.Builder;
import lombok.Getter;
import search.ship.babel.domain.Symbol;

@Getter
@Builder
public class SymbolInfoDto {
    private String projectName;

    private String symbolName;

    private String symbolCategory;

    private String symbolDesigner;

    private String imgName;

    private String imgType;

    public static SymbolInfoDto from(String projectName, Symbol symbol){
        return SymbolInfoDto.builder()
                .projectName(projectName)
                .symbolName(symbol.getSymbolName())
                .symbolCategory(symbol.getSymbolCategory())
                .symbolDesigner(symbol.getSymbolDesigner())
                .imgName(symbol.getImgName())
                .imgType(symbol.getImgType())
                .build();
    }
}
