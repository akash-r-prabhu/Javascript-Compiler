package ast;

public class IfStatementNode extends IfStmBase implements ASTNode {
	ExpBase condition;
	Statement statements;

    public IfStatementNode(ExpBase condition, Statement statements) {
        this.condition = condition;
        this.statements = statements;
    }

    @Override
    public void print() {
        System.out.println("IfStatementNode:");
        System.out.println("Condition:");
        condition.print();
        System.out.println("Statements:");
        statements.print();
    }
}
