package search.ship.babel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import search.ship.babel.domain.Ship;
import search.ship.babel.dto.ShipInfoRequest;
import search.ship.babel.dto.ShipInfoResponse;
import search.ship.babel.repository.ShipRepository;
import search.ship.babel.repository.ShipRepositorySupport;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ShipService {
    private final ShipRepository shipRepository;

    private final ShipRepositorySupport shipRepositorySupport;

    @Transactional(readOnly = true)
    public String projectSearch(String project) {
        Ship ship = this.shipRepository.findByProject(project).orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 없습니다"));

        return null;
    }

    @Transactional(readOnly = true)
    public ShipInfoResponse findShipInfoByCategory(ShipInfoRequest request) {
        final String largeCategory = request.getLargeCategory();
        final String middleCategory = request.getMiddleCategory();
        final String subCategory = request.getSubCategory();

        List<Ship> ship = shipRepositorySupport.findByCategory(largeCategory,middleCategory,subCategory);

        return null;
    }

}
