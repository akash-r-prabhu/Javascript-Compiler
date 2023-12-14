// TermNode.java
package ast;

public class TermNode extends TermBase implements ASTNode {
	TermBase leftOperand;
    String operator;
    FactorBase rightOperand;

    public TermNode(TermBase leftOperand, String operator, FactorBase rightOperand) {
        this.leftOperand = leftOperand;
        this.operator = operator;
        this.rightOperand = rightOperand;
    }

    @Override
    public void print() {
        System.out.println("TermNode:");
        System.out.println("├─ Left Operand:");
        leftOperand.print();
        System.out.println("├─ Operator: " + operator);
        System.out.println("└─ Right Operand:");
        rightOperand.print();
    }
}
