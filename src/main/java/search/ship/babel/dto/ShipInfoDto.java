package search.ship.babel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import search.ship.babel.domain.Ship;

@Builder
@AllArgsConstructor
public class ShipInfoDto {
    private String symbolName;

    private String imgSrc;

    public static ShipInfoDto from(Ship ship){
        return ShipInfoDto.builder()
                .symbolName(ship.getSymbolName())
                .imgSrc(ship.getImgSrc())
                .build();
    }
}
