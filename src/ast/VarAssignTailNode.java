// VarAssignTailNode.java
package ast;

public class VarAssignTailNode extends VarAssignBase implements ASTNode {
    String keywords;
    AssignTail assignstmTail;

    public VarAssignTailNode(String keywords, AssignTail assignstmTail) {
        this.keywords = keywords;
        this.assignstmTail = assignstmTail;
    }

    @Override
    public void print() {
        System.out.println("VarAssignTailNode:");
        System.out.println("├─ Keywords: " + keywords);
        System.out.println("└─ AssignStmTail:");
        assignstmTail.print();
    }
}
