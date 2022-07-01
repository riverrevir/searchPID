package search.ship.babel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import search.ship.babel.dto.*;
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
    public ShipInfoCategoryResponse getShipInfoByProject(@ModelAttribute ShipInfoProjectRequest request, Pageable pageable) {
        return shipService.findShipInfoByProject(request, pageable);
    }

    @GetMapping("/ship/category")
    public ShipInfoCategoryResponse getShipInfoByCategory(@ModelAttribute ShipInfoCategoryRequest request, Pageable pageable) {
        return shipService.findShipInfoByCategory(request, pageable);
    }

    @GetMapping("/ship/project/subcategory")
    public ShipInfoCategoryResponse getShipInfoBySubCategory(@ModelAttribute ShipInfoSubCategoryRequest request, Pageable pageable) {
        return shipService.findShipInfoBySubCategory(request, pageable);
    }
}
