// IncrementStmTypeNode.java
package ast;

public class IncrementStmTypeNode1 extends IncrementStmTypeBase implements ASTNode {
	PostIncBase incrementStmType;

    public IncrementStmTypeNode1(PostIncBase incrementStmType) {
        this.incrementStmType = incrementStmType;
    }

    @Override
    public void print() {
    	System.out.println("Increment Stm1(post) :");
        incrementStmType.print();
    }
}
