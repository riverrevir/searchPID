package search.ship.babel.dto.symbol;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SymbolSearchRequest {
    private String category;
    private String symbolName;
    private String designer;
}
