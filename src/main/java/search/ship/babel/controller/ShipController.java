package search.ship.babel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import search.ship.babel.dto.ShipInfoCategoryRequest;
import search.ship.babel.dto.ShipInfoCategoryResponse;
import search.ship.babel.dto.ShipInfoProjectRequest;
import search.ship.babel.service.ShipService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ShipController {

    private final ShipService shipService;

    @GetMapping("/ship/project")
    public ShipInfoCategoryResponse getShipInfoByProject(@RequestBody ShipInfoProjectRequest shipInfoProjectRequest){
        return shipService.findShipInfoByProject(shipInfoProjectRequest);
    }

    @GetMapping("/ship/category")
    public ShipInfoCategoryResponse getShipInfoByCategory(@RequestBody ShipInfoCategoryRequest shipInfoCategoryRequest){
        return shipService.findShipInfoByCategory(shipInfoCategoryRequest);
    }

}
