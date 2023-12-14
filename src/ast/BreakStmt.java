package ast;

public class BreakStmt extends BreakStmBase implements ASTNode {
    @Override
    public void print() {
        System.out.println("BreakStmt");
    }
}
