package search.ship.babel.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;
import search.ship.babel.domain.Ship;

import java.util.List;

import static search.ship.babel.domain.QShip.ship;

@Repository
public class ShipRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public ShipRepositorySupport(JPAQueryFactory queryFactory) {
        super(Ship.class);
        this.queryFactory = queryFactory;
    }

    public List<Ship> findByCategory(String largeCategory, String middleCategory, String subCategory) {
        return queryFactory
                .selectFrom(ship)
                .where(eqLargeCategory(largeCategory),
                        eqMiddleCategory(middleCategory),
                        eqSubCategory(subCategory))
                .fetch();
    }

    private BooleanExpression eqLargeCategory(String largeCategory) {
        if (StringUtils.isEmpty(largeCategory)) {
            return null;
        }
        return ship.largeCategory.eq(largeCategory);
    }

    private BooleanExpression eqMiddleCategory(String middleCategory) {
        if (StringUtils.isEmpty(middleCategory)) {
            return null;
        }
        return ship.middleCategory.eq(middleCategory);
    }

    private BooleanExpression eqSubCategory(String subCategory) {
        if (StringUtils.isEmpty(subCategory)) {
            return null;
        }
        return ship.subCategory.eq(subCategory);
    }
}
