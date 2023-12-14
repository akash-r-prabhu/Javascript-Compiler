package ast;

public class OperatorNode extends OperatorBase implements ASTNode {
    private String operator;

    public OperatorNode(String operator) {
        this.operator = operator;
    }

    @Override
    public void print() {
        System.out.print("OperatorNode: ");
        switch (operator) {
            case "ADD":
                System.out.println("Addition (+)");
                break;
            case "SUB":
                System.out.println("Subtraction (-)");
                break;
            case "MUL":
                System.out.println("Multiplication (*)");
                break;
            case "DIV":
                System.out.println("Division (/)");
                break;
            case "MOD":
                System.out.println("Modulus (%)");
                break;
            case "INC":
                System.out.println("Increment (++)");
                break;
            case "DEC":
                System.out.println("Decrement (--)");
                break;
            case "EXP":
                System.out.println("Exponent (^)");
                break;
            default:
                System.out.println("Unknown Operator");
        }
    }
}
