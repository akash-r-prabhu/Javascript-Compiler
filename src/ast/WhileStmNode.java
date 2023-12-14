package ast;

public class WhileStmNode extends WhileStmBase implements ASTNode {
	Stm2 stm;
	Statement statements;

    public WhileStmNode(Stm2 stm, Statement statements) {
        this.stm = stm;
        this.statements = statements;
    }

    @Override
    public void print() {
        System.out.println("WhileStmNode:");
        System.out.println("├─ Condition:");
        stm.print();
        System.out.println("└─ Statements:");
        statements.print();
    }
}
