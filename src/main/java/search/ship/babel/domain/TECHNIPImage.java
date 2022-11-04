package search.ship.babel.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity(name = "TECHNIPImage")
@Getter
@NoArgsConstructor
public class TECHNIPImage {
    @Id
    private String TECHNIPCode;

    @Column
    private String symbolCode;

    @Column
    private String TECHNIPFile;

    @Column
    private String label;

    @Column
    private String shape;
    @Column(nullable = false)
    private int sortingOrder=0;

    @ColumnDefault("0")
    @Column(nullable = false)
    private String unusedSymbol;

    public TECHNIPImage(String TECHNIPCode, String symbolCode, String TECHNIPFile) {
        this.TECHNIPCode = TECHNIPCode;
        this.symbolCode = symbolCode;
        this.TECHNIPFile = TECHNIPFile;
    }
}
