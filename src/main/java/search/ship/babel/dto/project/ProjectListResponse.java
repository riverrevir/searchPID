package search.ship.babel.dto.project;

import lombok.Getter;
import java.util.List;

@Getter
public class ProjectListResponse {
    List<String> projects;

    public ProjectListResponse(List<String> projects) {
        this.projects = projects;
    }
}
