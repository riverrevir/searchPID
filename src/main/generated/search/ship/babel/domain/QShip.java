package search.ship.babel.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QShip is a Querydsl query type for Ship
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShip extends EntityPathBase<Ship> {

    private static final long serialVersionUID = -1428163306L;

    public static final QShip ship = new QShip("ship");

    public final StringPath blueprint = createString("blueprint");

    public final StringPath imgSrc = createString("imgSrc");

    public final StringPath largeCategory = createString("largeCategory");

    public final StringPath middleCategory = createString("middleCategory");

    public final NumberPath<Long> number = createNumber("number", Long.class);

    public final StringPath project = createString("project");

    public final StringPath shipName = createString("shipName");

    public final StringPath subCategory = createString("subCategory");

    public final StringPath symbolName = createString("symbolName");

    public QShip(String variable) {
        super(Ship.class, forVariable(variable));
    }

    public QShip(Path<? extends Ship> path) {
        super(path.getType(), path.getMetadata());
    }

    public QShip(PathMetadata metadata) {
        super(Ship.class, metadata);
    }

}

