package search.ship.babel.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "designer")
@Getter
public class Designer {
    @Id
    private String designerCode;

    @Column
    private String designerName;
}
