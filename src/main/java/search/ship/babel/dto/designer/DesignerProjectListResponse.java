package search.ship.babel.dto.designer;


import lombok.Builder;
import lombok.Getter;
import search.ship.babel.domain.Project;


@Getter
@Builder
public class DesignerProjectListResponse {
    private String projectCode;

    public static DesignerProjectListResponse from(String projectCode) {
        return DesignerProjectListResponse.builder()
                .projectCode(projectCode)
                .build();
    }
}
