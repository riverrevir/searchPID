package search.ship.babel.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "KBRImage")
@Getter
@NoArgsConstructor
public class KBRImage {
    @Id
    private String KBRCode;

    @Column
    private String symbolCode;

    @Column
    private String KBRFile;

    @Column
    private String label;

    @Column
    private String shape;
    @Column(nullable = false)
    private int sortingOrder=0;

    public KBRImage(String KBRCode, String symbolCode, String KBRFile) {
        this.KBRCode = KBRCode;
        this.symbolCode = symbolCode;
        this.KBRFile = KBRFile;
    }
}
