// ComparisonTermNode.java
package ast;

public class ComparisonTermNode extends ComparisonBase implements ASTNode {
	AdditiveExpBase additiveExpression;

    public ComparisonTermNode(AdditiveExpBase additiveExpression) {
        this.additiveExpression = additiveExpression;
    }

    @Override
    public void print() {
        System.out.println("Additive Expresion:");
        additiveExpression.print();
    }
}
