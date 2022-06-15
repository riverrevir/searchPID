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

    private String imgName;

    private String imgType;

    public static ShipInfoDto from(Ship ship){
        return ShipInfoDto.builder()
                .symbolName(ship.getSymbolName())
                .imgName(ship.getImgName())
                .imgType(ship.getImgType())
                .build();
    }
}
