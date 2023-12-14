// ComparisonExpressionNode.java
package ast;

public class ComparisonExpressionNode extends ComparisonExpBase implements ASTNode {
    ComparisonOperator operator;
    ComparisonExpBase leftOperand;
    ComparisonBase rightOperand;

    public ComparisonExpressionNode(ComparisonOperator operator, ComparisonExpBase leftOperand, ComparisonBase rightOperand) {
        this.operator = operator;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public void print() {
        System.out.println("ComparisonExpressionNode:");
        System.out.println("├─ Left Operand:");
        leftOperand.print();
        System.out.println("├─ Operator: " + operator);
        System.out.println("└─ Right Operand:");
        rightOperand.print();
    }
}
