// PostIncrementStmNode.java
package ast;

public class PostIncrementStmNode extends PostIncBase implements ASTNode {
    private String identifier;

    public PostIncrementStmNode(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public void print() {
        System.out.println("PostIncrementStmNode:");
        System.out.println("└─ Identifier: " + identifier);
    }
}
