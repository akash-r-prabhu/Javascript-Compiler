// NewIDFactorNode.java
package ast;

public class NewIDFactorNode extends AssignTail implements ASTNode {
    String newID;
    FactorBase factor;

    public NewIDFactorNode(String newID, FactorBase factor) {
        this.newID = newID;
        this.factor = factor;
    }

    @Override
    public void print() {
        System.out.println("NewIDFactorNode:");
        System.out.println("├─ New ID: " + newID);
        System.out.println("└─ Factor:");
        factor.print();
    }
}
