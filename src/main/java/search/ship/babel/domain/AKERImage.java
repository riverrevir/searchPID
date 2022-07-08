package search.ship.babel.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity(name = "AKERImage")
@Getter
public class AKERImage {
    @Id
    private String AKERCode;

    @Column
    private String symbolCode;

    @Column
    private String AKERFile;
}
