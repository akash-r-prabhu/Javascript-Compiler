package ast;

public class StatementsElseNode implements ASTNode {
    private ASTNode statements;
    private ASTNode elsePart;

    public StatementsElseNode(ASTNode statements, ASTNode elsePart) {
        this.statements = statements;
        this.elsePart = elsePart;
    }

    @Override
    public void print() {
        System.out.println("StatementsElseNode:");
        System.out.println("├─ Statements:");
        statements.print();
        System.out.println("└─ Else Part:");
        elsePart.print();
    }
}