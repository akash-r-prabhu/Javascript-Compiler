package ast;

public class KeywordsNode implements ASTNode {
    private String keywords;

    public KeywordsNode(String keywords) {
        this.keywords = keywords;
    }

    @Override
    public void print() {
        System.out.println("KeywordsNode: " + keywords);
    }
}
