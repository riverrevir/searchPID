package search.ship.babel.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;
import search.ship.babel.domain.Symbol;

import java.util.List;

import static search.ship.babel.domain.QSymbol.symbol;

@Repository
public class SymbolRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public SymbolRepositorySupport(JPAQueryFactory queryFactory) {
        super(Symbol.class);
        this.queryFactory = queryFactory;
    }

    public List<Symbol> findAllByCategory(String category, String symbolName, String designer) {
        return queryFactory
                .selectFrom(symbol)
                .where(eqCategory(category),
                        eqSymbolName(symbolName),
                        eqDesigner(designer))
                .fetch();
    }

    private BooleanExpression eqCategory(String category) {
        if (StringUtils.isEmpty(category)) {
            return null;
        }
        return symbol.symbolCategory.eq(category);
    }

    private BooleanExpression eqSymbolName(String symbolName) {
        if (StringUtils.isEmpty(symbolName)) {
            return null;
        }
        return symbol.symbolName.eq(symbolName);
    }

    private BooleanExpression eqDesigner(String designer) {
        if (StringUtils.isEmpty(designer)) {
            return null;
        }
        return symbol.symbolDesigner.eq(designer);
    }
}
