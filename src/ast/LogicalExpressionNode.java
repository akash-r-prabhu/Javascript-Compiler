// LogicalExpressionNode.java
package ast;

public class LogicalExpressionNode extends LogicalExpBase implements ASTNode {
    LogicalOperator operator;
    LogicalExpBase leftOperand;
    ComparisonBase rightOperand;

    public LogicalExpressionNode(LogicalOperator operator, LogicalExpBase leftOperand, ComparisonBase rightOperand) {
        this.operator = operator;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public void print() {
        System.out.println("LogicalExpressionNode:");
        if(this.leftOperand != null) {
        System.out.println("├─ Left Operand:");
        }
        leftOperand.print();
        if(this.operator != null) {
        System.out.println("├─ Operator: " + operator);
        }
        System.out.println("└─ Right Operand:");
        rightOperand.print();
    }
}
