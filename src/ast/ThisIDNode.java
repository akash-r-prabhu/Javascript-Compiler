package ast;

public class ThisIDNode extends FactorBase implements ASTNode {
    private String id;

    public ThisIDNode(String id) {
        this.id = id;
    }

    @Override
    public void print() {
        System.out.println("ThisIDNode: " + id);
    }
}
