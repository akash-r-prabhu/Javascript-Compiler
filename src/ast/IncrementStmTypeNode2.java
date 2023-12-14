// IncrementStmTypeNode.java
package ast;

public class IncrementStmTypeNode2 extends IncrementStmTypeBase implements ASTNode {
	PreIncBase incrementStmType;

    public IncrementStmTypeNode2(PreIncBase incrementStmType) {
        this.incrementStmType = incrementStmType;
    }

    @Override
    public void print() {
    	System.out.println("Increment Stm2(pre) :");
        incrementStmType.print();
    }
}
