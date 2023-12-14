// AdditiveExpressionNode.java
package ast;

public class AdditiveExpressionNode extends AdditiveExpBase implements ASTNode {
    private ASTNode leftOperand;
    private String operator;
    private ASTNode rightOperand;

    public AdditiveExpressionNode(ASTNode leftOperand, String operator, ASTNode rightOperand) {
        this.leftOperand = leftOperand;
        this.operator = operator;
        this.rightOperand = rightOperand;
    }

    @Override
    public void print() {
        System.out.println("AdditiveExpressionNode:");
        System.out.println("├─ Left Operand:");
        leftOperand.print();
        System.out.println("├─ Operator: " + operator);
        System.out.println("└─ Right Operand:");
        rightOperand.print();
    }
}
