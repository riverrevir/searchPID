package search.ship.babel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import search.ship.babel.dto.ShipInfoRequest;
import search.ship.babel.dto.ShipInfoResponse;
import search.ship.babel.service.ShipService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ShipController {

    private final ShipService shipService;

    @GetMapping("/ship/category")
    public ShipInfoResponse getShipInfoByCategory(@RequestBody ShipInfoRequest shipInfoRequest){
        return shipService.findShipInfoByCategory(shipInfoRequest);
    }

}
