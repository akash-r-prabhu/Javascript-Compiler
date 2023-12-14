// ListElementNode.java
package ast;

public class ListElementNode extends ListBase implements ASTNode {
	FactorBase factor;
	ListBase expression;

    public ListElementNode(FactorBase factor) {
        this.factor = factor;
    }

    public ListElementNode(FactorBase factor, ListBase expression) {
        this.factor = factor;
        this.expression = expression;
    }

    @Override
    public void print() {
        System.out.println("ListElementNode:");
        factor.print();
        if (expression != null) {
            expression.print();
        }
    }
}
