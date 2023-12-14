// ElementNode.java
package ast;

public class ElementNode extends ElementBase implements ASTNode {
    private String id;
    private int intValue;
    FactorBase factor1;
    FactorBase factor2;;
    ExpBase expression;
    // Constructor for ID
    public ElementNode(String id) {
        this.id = id;
    }

    // Constructor for INT
    public ElementNode(int intValue) {
        this.intValue = intValue;
    }

    // Constructor for LPAREN RPAREN
    public ElementNode() {
        // Empty constructor for LPAREN RPAREN
    }

    // Constructor for LBRACES factor COLON factor RBRACES
    public ElementNode(FactorBase factor1, FactorBase factor2) {
        this.factor1 = factor1;
        this.factor2 = factor2;
    }

    // Constructor for Exp 
    public ElementNode(ExpBase expression) {
        this.expression = expression;
    }

    @Override
    public void print() {
        System.out.println("ElementNode:");
        if (id != null) {
            System.out.println("├─ ID: " + id);
        } else if (intValue != 0) {
            System.out.println("├─ INT: " + intValue);
        }else if (factor1 != null && factor2 != null) {
            System.out.println("├─ LBRACES:");
            factor1.print();
            System.out.println("└─ COLON:");
            factor2.print();
        } else if (expression != null) {
            System.out.println("├─ EXPRESSION:");
            expression.print();
        } else {
            System.out.println("├─ LPAREN RPAREN");
        }
    }
}
