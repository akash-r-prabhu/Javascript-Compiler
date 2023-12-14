// ReturnStmNode.java
package ast;

public class ReturnStmNode2 extends ReturnBase implements ASTNode {
	SelfAssignBase expression;

    public ReturnStmNode2(SelfAssignBase expression) {
        this.expression = expression;
    }

    @Override
    public void print() {
        System.out.println("ReturnStmNode2:");
        expression.print();
    }
}
