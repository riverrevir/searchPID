package search.ship.babel.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity(name = "KBRImage")
@Getter
public class KBRImage {
    @Id
    private String KBRCode;

    @Column
    private String symbolCode;

    @Column
    private String KBRFile;


}
