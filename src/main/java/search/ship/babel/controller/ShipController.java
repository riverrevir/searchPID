package search.ship.babel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import search.ship.babel.dto.ShipInfoCategoryRequest;
import search.ship.babel.dto.ShipInfoCategoryResponse;
import search.ship.babel.dto.ShipInfoDto;
import search.ship.babel.dto.ShipInfoProjectRequest;
import search.ship.babel.service.FileService;
import search.ship.babel.service.ShipService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ShipController {

    private final ShipService shipService;

    private final FileService fileService;

    @GetMapping("/ship/project")
    public ShipInfoCategoryResponse getShipInfoByProject(@ModelAttribute ShipInfoProjectRequest shipInfoProjectRequest, Pageable pageable) {
        return shipService.findShipInfoByProject(shipInfoProjectRequest,pageable);
    }

    @GetMapping("/ship/category")
    public ShipInfoCategoryResponse getShipInfoByCategory(@ModelAttribute ShipInfoCategoryRequest shipInfoCategoryRequest, Pageable pageable) {
        return shipService.findShipInfoByCategory(shipInfoCategoryRequest,pageable);
    }
}
