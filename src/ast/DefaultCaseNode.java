package ast;

public class DefaultCaseNode implements ASTNode {
    private ASTNode stm;

    public DefaultCaseNode(ASTNode stm) {
        this.stm = stm;
    }

    @Override
    public void print() {
        System.out.println("DefaultCaseNode:");
        System.out.println("Statement:");
        stm.print();
    }
}
