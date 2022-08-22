package search.ship.babel.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public TECHNIPImage(String TECHNIPCode, String symbolCode, String TECHNIPFile) {
        this.TECHNIPCode = TECHNIPCode;
        this.symbolCode = symbolCode;
        this.TECHNIPFile = TECHNIPFile;
    }
}
