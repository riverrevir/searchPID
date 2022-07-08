package search.ship.babel.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name="classification")
@Getter
public class Classification {
    @Id
    private String classificationCode;

    @Column
    private String classificationName;

}
