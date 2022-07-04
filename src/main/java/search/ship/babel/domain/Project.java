package search.ship.babel.domain;

import javax.persistence.*;

@Entity(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectNumber;

    private String projectName;
}
