package ast;

public class IntNode extends FactorBase implements ASTNode {
    private int value;

    public IntNode(int value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.println("IntNode: " + value);
    }
}
