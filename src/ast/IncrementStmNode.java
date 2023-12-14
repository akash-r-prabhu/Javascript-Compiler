// IncrementStmNode.java
package ast;

public class IncrementStmNode extends IncrementBase implements ASTNode {
	IncrementStmTypeBase incrementStmType;

    public IncrementStmNode(IncrementStmTypeBase incrementStmType) {
        this.incrementStmType = incrementStmType;
    }

    @Override
    public void print() {
        System.out.println("IncrementStmNode:");
        System.out.println("└─ Increment Stm Type:");
        incrementStmType.print();
    }
}
