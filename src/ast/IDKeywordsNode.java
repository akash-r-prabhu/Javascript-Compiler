package ast;

public class IDKeywordsNode extends FactorBase implements ASTNode {
    private String id;
    private String keywords;

    public IDKeywordsNode(String id, String keywords) {
        this.id = id;
        this.keywords = keywords;
    }

    @Override
    public void print() {
        System.out.println("IDKeywordsNode: " + id + " DOT " + keywords);
    }
}