package search.ship.babel.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import search.ship.babel.domain.Ship;
import search.ship.babel.dto.ShipInfoCategoryRequest;
import search.ship.babel.dto.ShipInfoCategoryResponse;
import search.ship.babel.dto.ShipInfoProjectRequest;
import search.ship.babel.dto.ShipInfoSubCategoryRequest;
import search.ship.babel.repository.ShipRepository;
import search.ship.babel.repository.ShipRepositorySupport;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ShipService {
    private final ShipRepository shipRepository;

    private final ShipRepositorySupport shipRepositorySupport;

    @Transactional(readOnly = true)
    public ShipInfoCategoryResponse findShipInfoByProject(ShipInfoProjectRequest request, Pageable pageable) {
        final String project = request.getProject();
        Page<Ship> ship = shipRepository.findAllByProject(project, pageable);
        return ShipInfoCategoryResponse.from(ship);
    }

    @Transactional(readOnly = true)
    public ShipInfoCategoryResponse findShipInfoByCategory(ShipInfoCategoryRequest request, Pageable pageable) {
        final String largeCategory = request.getLargeCategory();
        final String middleCategory = request.getMiddleCategory();
        final String subCategory = request.getSubCategory();
        Page<Ship> ship = shipRepositorySupport.findAllByCategory(largeCategory, middleCategory, subCategory, pageable);
        return ShipInfoCategoryResponse.from(ship);
    }

    @Transactional(readOnly = true)
    public ShipInfoCategoryResponse findShipInfoBySubCategory(ShipInfoSubCategoryRequest request, Pageable pageable) {
        final String subCategory = request.getSubCategory();
        Page<Ship> ship = shipRepository.findBySubCategory(subCategory, pageable);
        return ShipInfoCategoryResponse.from(ship);
    }
}
