package search.ship.babel.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity(name = "symbol")
public class Symbol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long symbolNumber;

    private String symbolCategory;

    private String symbolName;

    @Column(name = "img_name")
    private String imgName;

    @Column(name = "img_type")
    private String imgType;

    private String symbolDesigner;

    @OneToMany(mappedBy = "symbol")
    private List<ProjectSymbol> projectSymbols;
}
