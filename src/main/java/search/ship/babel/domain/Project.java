package search.ship.babel.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "project")
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectIndex;

    @Column
    private String projectCode;

    @Column
    private String designerCode;

    @Column
    private String symbolList;

    @Column
    private LocalDateTime projectCreateAt;

    public Project() {
        projectCreateAt = LocalDateTime.now();
    }

}
