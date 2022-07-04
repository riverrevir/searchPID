package search.ship.babel.dto.list;

import lombok.Getter;
import java.util.List;

@Getter
public class DesignerListResponse {
    List<String> symbolDesigners;
    public DesignerListResponse(List<String> list){
        this.symbolDesigners=list;
    }
}
