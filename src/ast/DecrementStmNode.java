// DecrementStmNode.java
package ast;

public class DecrementStmNode extends DecStmBase implements ASTNode {
	DecStmTypeBase decrementType;

    public DecrementStmNode(DecStmTypeBase decrementType) {
        this.decrementType = decrementType;
    }

    @Override
    public void print() {
        System.out.println("DecrementStmNode:");
        System.out.println("└─ Decrement Stm Type:");
        decrementType.print();
    }
}
