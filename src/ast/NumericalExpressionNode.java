// NumericalExpressionNode.java
package ast;

public class NumericalExpressionNode implements ASTNode {
    private ASTNode left;
    private String operator;
    private ASTNode right;

    public NumericalExpressionNode(ASTNode left, String operator, ASTNode right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public void print() {
        System.out.println("NumericalExpressionNode:");
        System.out.println("├─ Left:");
        left.print();
        System.out.println("├─ Operator: " + operator);
        System.out.println("└─ Right:");
        right.print();
    }
}
