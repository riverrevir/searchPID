package search.ship.babel.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity(name = "AKERImage")
@Getter
@NoArgsConstructor
public class AKERImage {
    @Id
    private String AKERCode;

    @Column
    private String symbolCode;

    @Column
    private String AKERFile;

    @Column
    private String label;

    @Column
    private String shape;
    @Column(nullable = false)
    private int sortingOrder=0;

    @ColumnDefault("0")
    @Column(nullable = false)
    private String unusedSymbol;
    public AKERImage(String AKERCode, String symbolCode, String AKERFile) {
        this.AKERCode = AKERCode;
        this.symbolCode = symbolCode;
        this.AKERFile = AKERFile;
    }
}
