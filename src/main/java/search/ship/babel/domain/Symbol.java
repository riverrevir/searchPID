package search.ship.babel.domain;

import javax.persistence.*;

@Entity(name = "symbol")
public class Symbol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    private String symbolCategory;

    private String symbolName;

    @Column(name = "img_name")
    private String imgName;

    @Column(name = "img_type")
    private String imgType;

    private String symbolDesigner;
}
