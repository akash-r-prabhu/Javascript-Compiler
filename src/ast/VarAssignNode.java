// VarAssignNode.java
package ast;

public class VarAssignNode extends VarAssignBase implements ASTNode {
    String id;
    AssignTail assignstmTail;

    public VarAssignNode(String id, AssignTail assignstmTail) {
        this.id = id;
        this.assignstmTail = assignstmTail;
    }

    @Override
    public void print() {
        System.out.println("VarAssignNode:");
        System.out.println("├─ ID: " + id);
        System.out.println("└─ AssignStmTail:");
        assignstmTail.print();
    }
}
