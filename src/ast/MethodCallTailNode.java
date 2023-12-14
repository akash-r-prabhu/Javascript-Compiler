// MethodCallTailNode.java
package ast;

public class MethodCallTailNode extends MethodCallBase implements ASTNode {

    InnerExpBase innerExpression;

    public MethodCallTailNode(InnerExpBase innerExpression) {
		super();
		this.innerExpression = innerExpression;
	}



    @Override
    public void print() {
        System.out.println("MethodCallTailNode:");
       if (innerExpression != null) {
            System.out.println("  Inner Expression:");
            innerExpression.print();
        }
    }
}
