// ReturnStmNode.java
package ast;

public class ReturnStmNode extends ReturnBase implements ASTNode {
    Stm2 expression;

    public ReturnStmNode(Stm2 expression) {
        this.expression = expression;
    }

    @Override
    public void print() {
        System.out.println("ReturnStmNode:");
        expression.print();
    }
}
