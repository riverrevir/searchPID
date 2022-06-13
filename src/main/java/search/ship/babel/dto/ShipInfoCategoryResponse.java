package search.ship.babel.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;
import search.ship.babel.domain.Ship;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ShipInfoCategoryResponse {
    private Page<ShipInfoDto> shipInfos;

    public static ShipInfoCategoryResponse from(Page<Ship> ship){
        Page<ShipInfoDto> shipInfoDtoList = ship.map(ShipInfoDto::from);
        return new ShipInfoCategoryResponse(shipInfoDtoList);
    }
}
