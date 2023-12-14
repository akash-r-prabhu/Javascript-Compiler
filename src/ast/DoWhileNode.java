// DoWhileNode.java
package ast;

public class DoWhileNode extends DoWhileBase implements ASTNode {
	Statement statements;
	Stm2 stm;

    public DoWhileNode(Statement statements, Stm2 stm) {
        this.statements = statements;
        this.stm = stm;
    }

    @Override
    public void print() {
        System.out.println("DoWhileNode:");
        System.out.println("├─ Statements:");
        statements.print();
        System.out.println("└─ While Condition:");
        stm.print();
    }
}
