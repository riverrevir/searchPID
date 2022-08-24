package search.ship.babel.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public AKERImage(String AKERCode, String symbolCode, String AKERFile) {
        this.AKERCode = AKERCode;
        this.symbolCode = symbolCode;
        this.AKERFile = AKERFile;
    }
}
