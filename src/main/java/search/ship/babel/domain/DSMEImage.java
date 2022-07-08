package search.ship.babel.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity(name = "DSMEImage")
@Getter
public class DSMEImage {
    @Id
    private String DSMECode;

    @Column
    private String symbolCode;

    @Column
    private String DSMEFile;


}
