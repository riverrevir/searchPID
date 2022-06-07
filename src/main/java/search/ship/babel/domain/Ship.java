package search.ship.babel.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name="ship")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ship_number")
    private Long number;

    @Column(name = "ship_pid")
    private String pid;

    @Column(name = "ship_project")
    private String project;

    @Column(name = "ship_blueprint")
    private String blueprint;

    @Column(name = "ship_p-name")
    private String p_name;

    @Column(name = "ship_img-src")
    private String img_src;

    
}
