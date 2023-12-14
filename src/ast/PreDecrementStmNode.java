// PreDecrementStmNode.java
package ast;

public class PreDecrementStmNode extends PreDecBase implements ASTNode {
    private String identifier;

    public PreDecrementStmNode(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public void print() {
        System.out.println("PreDecrementStmNode:");
        System.out.println("└─ ID: " + identifier);
    }
}
