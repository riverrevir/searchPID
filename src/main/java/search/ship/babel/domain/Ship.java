package search.ship.babel.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "ship")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Number")
    private Long number;

    @Column(name = "large_category")
    private String largeCategory;

    @Column(name = "middle_category")
    private String middleCategory;

    @Column(name = "sub_category")
    private String subCategory;

    @Column(name = "project")
    private String project;

    @Column(name = "ship_name")
    private String shipName;

    @Column(name = "blueprint")
    private String blueprint;

    @Column(name = "symbol_name")
    private String symbolName;

    @Column(name = "img_src")
    private String imgSrc;

}
