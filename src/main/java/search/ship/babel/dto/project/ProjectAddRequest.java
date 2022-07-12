package search.ship.babel.dto.project;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ProjectAddRequest {
    @NotNull
    private String projectCode;

    @NotNull
    private String designerName;

    @NotNull
    private String currentSymbolList;

    @NotNull
    private String symbolList;
}
