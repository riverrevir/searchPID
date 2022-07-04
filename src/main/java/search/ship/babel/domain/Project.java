package search.ship.babel.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectNumber;

    @Column(unique = true)
    private String projectName;

    @OneToMany(mappedBy = "project")
    private List<ProjectSymbol> projectSymbols = new ArrayList<>();
}
