package ast;

public class CaseItemNode implements ASTNode {
    private ASTNode exp;
    private ASTNode stm;
    private ASTNode breakStmt;

    public CaseItemNode(ASTNode exp, ASTNode stm, ASTNode breakStmt) {
        this.exp = exp;
        this.stm = stm;
        this.breakStmt = breakStmt;
    }

    @Override
    public void print() {
        System.out.println("CaseItemNode:");
        System.out.print("Expression: ");
        exp.print();
        System.out.println("Statement:");
        stm.print();
        if (breakStmt != null) {
            System.out.println("Break:");
            breakStmt.print();
        }
    }
}