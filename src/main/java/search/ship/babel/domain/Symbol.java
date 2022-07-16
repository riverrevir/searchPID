package search.ship.babel.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "symbol")
@Getter
public class Symbol {
    @Id
    private String symbolCode;

    @Column
    private String symbolName;

}
