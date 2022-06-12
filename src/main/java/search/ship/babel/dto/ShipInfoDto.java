package search.ship.babel.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import search.ship.babel.domain.Ship;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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
