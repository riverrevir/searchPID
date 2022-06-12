package search.ship.babel.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "ship")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Number")
    private Long number;

    @Column(name = "Pid")
    private String pid;

    @Column(name = "Project")
    private String project;

    @Column(name = "ShipName")
    private String shipName;

    @Column(name = "Blueprint")
    private String blueprint;

    @Column(name = "PName")
    private String pName;

    @Column(name = "ImgSrc")
    private String imgSrc;

}
