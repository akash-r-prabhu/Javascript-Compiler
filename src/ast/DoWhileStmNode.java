// DoWhileStmNode.java
package ast;

public class DoWhileStmNode implements ASTNode {
    private ASTNode stm;

    public DoWhileStmNode(ASTNode stm) {
        this.stm = stm;
    }

    @Override
    public void print() {
        System.out.println("DoWhileStmNode:");
        System.out.println("└─ While Condition:");
        stm.print();
    }
}
