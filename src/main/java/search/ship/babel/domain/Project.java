package search.ship.babel.domain;


import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "project")
@Getter
public class Project {
    @Id
    private String projectCode;

    @Column
    private String designerCode;

    @Column
    private String projectList;
}
