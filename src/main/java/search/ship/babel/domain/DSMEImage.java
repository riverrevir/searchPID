package search.ship.babel.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity(name = "DSMEImage")
@Getter
@NoArgsConstructor
public class DSMEImage {
    @Id
    private String DSMECode;

    @Column
    private String symbolCode;

    @Column
    private String DSMEFile;

    @Column
    private String label;

    @Column
    private String shape;
    @Column(nullable = false)
    private int sortingOrder=0;

    @ColumnDefault("0")
    @Column(nullable = false)
    private String unusedSymbol;
    public DSMEImage(String DSMECode, String symbolCode, String DSMEFile) {
        this.DSMECode = DSMECode;
        this.symbolCode = symbolCode;
        this.DSMEFile = DSMEFile;
    }
}
