package search.ship.babel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import search.ship.babel.domain.Ship;
import search.ship.babel.repository.ShipRepository;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ShipService {
    private final ShipRepository shipRepository;

    @Transactional
    public String symbolSearch(String symbol) throws Exception {
        Ship ship = this.shipRepository.findByp_name(symbol).orElseThrow(() -> new Exception("해당 심볼이 없습니다."));
        return ship.getP_name();
    }
}
