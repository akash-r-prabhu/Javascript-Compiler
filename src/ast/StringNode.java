package ast;

public class StringNode extends FactorBase implements ASTNode {
    private String value;

    public StringNode(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.println("		└─ StringNode: " + value);
    }
}
