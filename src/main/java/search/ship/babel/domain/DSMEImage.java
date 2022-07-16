package search.ship.babel.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public DSMEImage(String DSMECode, String symbolCode, String DSMEFile) {
        this.DSMECode = DSMECode;
        this.symbolCode = symbolCode;
        this.DSMEFile = DSMEFile;
    }
}
