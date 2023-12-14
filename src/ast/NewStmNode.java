// NewStmNode.java
package ast;

public class NewStmNode implements ASTNode {
    private ASTNode stm;

    public NewStmNode(ASTNode stm) {
        this.stm = stm;
    }

    @Override
    public void print() {
        System.out.println("NewStmNode:");
        stm.print();
    }
}
