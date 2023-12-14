// AssignStmtTailNode.java
package ast;

public class AssignStmtTailNode2 extends AssignTail implements ASTNode {
	ExpBase content;

    public AssignStmtTailNode2(ExpBase content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println("AssignStmtTailNode2: ");
        content.print();
    }
}
