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
//
//    @Transactional
//    public String symbolSearch(String symbol){
//        Ship ship = this.shipRepository.findByPName(symbol).orElseThrow(() -> new Exception("해당 심볼이 없습니다."));
//        return ship.getPName();
//    }

    @Transactional
    public String projectSearch(String project){
        Ship ship=this.shipRepository.findByProject(project).orElseThrow(()->new IllegalArgumentException("해당 프로젝트가 없습니다"));

        return ship.g
    }
}
