package search.ship.babel.dto.designer;

import lombok.Getter;

import java.util.List;

@Getter
public class DesignerImageAddRequest {
    private String designerName;
    private List<String> symbolCode;
    private List<Integer> count;
}
