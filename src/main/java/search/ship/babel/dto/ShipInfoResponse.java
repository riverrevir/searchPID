package search.ship.babel.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import search.ship.babel.domain.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ShipInfoResponse {
    private List<ShipInfoDto> shipInfos;

    public static ShipInfoResponse from(List<Ship> ship){
        List<ShipInfoDto> shipInfoDtoList = ship.stream().map(ShipInfoDto::from).collect(Collectors.toList());
        return new ShipInfoResponse(shipInfoDtoList);
    }
}
