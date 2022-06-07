package search.ship.babel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import search.ship.babel.repository.ShipRepository;
import search.ship.babel.service.ShipService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api")
public class ShipController {

    private final ShipRepository shipRepository;
    private final ShipService shipService;

    @GetMapping("/symbol")
    public String symbol(String symbol) throws Exception {
        return shipService.symbolSearch(symbol);
    }
}
