// PostDecrementStmNode.java
package ast;

public class PostDecrementStmNode extends PostDecBase implements ASTNode {
    private String identifier;

    public PostDecrementStmNode(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public void print() {
        System.out.println("PostDecrementStmNode:");
        System.out.println("└─ ID: " + identifier);
    }
}
