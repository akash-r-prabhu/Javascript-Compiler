package ast;

public class KeywordsIDNode extends FactorBase implements ASTNode {
    private String keywords;
    private String id;

    public KeywordsIDNode(String keywords, String id) {
        this.keywords = keywords;
        this.id = id;
    }

    @Override
    public void print() {
        System.out.println("KeywordsIDNode: " + keywords + " DOT " + id);
    }
}
