package search.ship.babel.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity(name = "TECHNIPImage")
@Getter
public class TECHNIPImage {
    @Id
    private String TECHNIPCode;

    @Column
    private String symbolCode;

    @Column
    private String TECHNIPFile;
}
