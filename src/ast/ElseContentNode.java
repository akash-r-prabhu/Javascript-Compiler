package ast;

public class ElseContentNode extends elseContentBase implements ASTNode {
	IfStmBase ifStatement;
	Statement statements;

    public ElseContentNode(IfStmBase ifStatement, Statement statements) {
        this.ifStatement = ifStatement;
        this.statements = statements;
    }

    public ASTNode getIfStatement() {
        return ifStatement;
    }

    public ASTNode getStatements() {
        return statements;
    }

    @Override
    public void print() {
        System.out.println("ElseContentNode:");
        if (ifStatement != null) {
            System.out.println("├─ IfStatement:");
            ifStatement.print();
        }
        if (statements != null) {
            System.out.println("└─ Statements:");
            statements.print();
        }
    }
}
