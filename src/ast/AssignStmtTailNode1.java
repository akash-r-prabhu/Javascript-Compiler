// AssignStmtTailNode.java
package ast;

public class AssignStmtTailNode1 extends AssignTail implements ASTNode {
	FunctionCallBase content;

    public AssignStmtTailNode1(FunctionCallBase content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println("AssignStmtTailNode1: (");
        content.print();
    }
}
