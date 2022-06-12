package search.ship.babel.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import search.ship.babel.domain.Ship;
import search.ship.babel.dto.ShipInfoCategoryRequest;
import search.ship.babel.dto.ShipInfoCategoryResponse;
import search.ship.babel.dto.ShipInfoProjectRequest;
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

    /**
     * todo
     */
    @Transactional(readOnly = true)
    public ShipInfoCategoryResponse findShipInfoByProject(ShipInfoProjectRequest request) {
        final String project = request.getProject();

        List<Ship> ship = shipRepository.findByProject(project);
        ship.stream().forEach(s->log.info(s.toString()));
        return ShipInfoCategoryResponse.from(ship);
    }

    @Transactional(readOnly = true)
    public ShipInfoCategoryResponse findShipInfoByCategory(ShipInfoCategoryRequest request) {
        final String largeCategory = request.getLargeCategory();
        final String middleCategory = request.getMiddleCategory();
        final String subCategory = request.getSubCategory();

        List<Ship> ship = shipRepositorySupport.findByCategory(largeCategory, middleCategory, subCategory);
        return ShipInfoCategoryResponse.from(ship);
    }

}
