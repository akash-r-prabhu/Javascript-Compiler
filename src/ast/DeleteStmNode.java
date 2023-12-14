// DeleteStmNode.java
package ast;

public class DeleteStmNode extends DeleteStmBase implements ASTNode {
	FactorBase factor;

    public DeleteStmNode(FactorBase factor) {
        this.factor = factor;
    }

    @Override
    public void print() {
        System.out.println("DeleteStmNode:");
        factor.print();
    }
}
