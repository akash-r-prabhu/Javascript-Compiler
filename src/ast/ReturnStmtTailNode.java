// ReturnStmtTailNode.java
package ast;

public class ReturnStmtTailNode extends ReturnBase implements ASTNode {
    private String keyword;

    public ReturnStmtTailNode(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void print() {
        System.out.println("ReturnStmtTailNode:");
        System.out.println("└─ Keyword: " + keyword);
    }
}
