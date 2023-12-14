package ast;

public class CompOperatorNode extends CompOperatorBase implements ASTNode {
    private String operator;

    public CompOperatorNode(String operator) {
        this.operator = operator;
    }

    @Override
    public void print() {
        System.out.print("CompOperatorNode: ");
        switch (operator) {
            case "EQUAL":
                System.out.println("==");
                break;
            case "EQUALS":
                System.out.println("===");
                break;
            case "NEQ":
                System.out.println("!=");
                break;
            case "SEQ":
                System.out.println("===");
                break;
            case "SNEQ":
                System.out.println("!==");
                break;
            case "GT":
                System.out.println(">");
                break;
            case "LT":
                System.out.println("<");
                break;
            case "GEQ":
                System.out.println(">=");
                break;
            case "LEQ":
                System.out.println("<=");
                break;
            case "TEN":
                System.out.println("?");
                break;
            default:
                System.out.println("Unknown operator");
        }
    }
}
