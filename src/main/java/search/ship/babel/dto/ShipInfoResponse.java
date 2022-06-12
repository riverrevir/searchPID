package search.ship.babel.dto;

import search.ship.babel.domain.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShipInfoResponse {
    private List<ShipInfoDto> shipInfos = new ArrayList<>();

    public static ShipInfoResponse from(List<Ship> ship){

    }
}
