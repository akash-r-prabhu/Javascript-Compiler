// PreIncrementStmNode.java
package ast;

public class PreIncrementStmNode extends PreIncBase implements ASTNode {
    private String identifier;

    public PreIncrementStmNode(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public void print() {
        System.out.println("PreIncrementStmNode:");
        System.out.println("└─ Identifier: " + identifier);
    }
}
