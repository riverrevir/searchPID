package search.ship.babel.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class ProjectSymbol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectSymbolNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_number")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "symbol_number")
    private Symbol symbol;

    public void addProjectAndSymbol(Project project, Symbol symbol) {
        setProject(project);
        setSymbol(symbol);
    }

    private void setProject(Project project) {
        this.project = project;

        this.project.getProjectSymbols().add(this);
    }

    private void setSymbol(Symbol symbol) {
        this.symbol = symbol;

        this.symbol.getProjectSymbols().add(this);
    }
}
