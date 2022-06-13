package search.ship.babel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import search.ship.babel.dto.ShipInfoCategoryRequest;
import search.ship.babel.dto.ShipInfoCategoryResponse;
import search.ship.babel.dto.ShipInfoProjectRequest;
import search.ship.babel.service.ShipService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ShipController {

    private final ShipService shipService;

    @GetMapping("/ship/project")
    public ShipInfoCategoryResponse getShipInfoByProject(@ModelAttribute ShipInfoProjectRequest shipInfoProjectRequest){
        return shipService.findShipInfoByProject(shipInfoProjectRequest);
    }

    @GetMapping("/ship/category")
    public ShipInfoCategoryResponse getShipInfoByCategory(@ModelAttribute ShipInfoCategoryRequest shipInfoCategoryRequest){
        return shipService.findShipInfoByCategory(shipInfoCategoryRequest);
    }

}
