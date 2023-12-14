package ast;

public class LengthNode extends FactorBase implements ASTNode {
    private String id;

    public LengthNode(String id) {
        this.id = id;
    }

    @Override
    public void print() {
        System.out.println("LengthNode: " + id);
    }
}
