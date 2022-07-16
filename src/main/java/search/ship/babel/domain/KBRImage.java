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

    public KBRImage(String KBRCode, String symbolCode, String KBRFile) {
        this.KBRCode = KBRCode;
        this.symbolCode = symbolCode;
        this.KBRFile = KBRFile;
    }
}
