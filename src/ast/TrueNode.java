package ast;

public class TrueNode extends FactorBase implements ASTNode {
    @Override
    public void print() {
        System.out.println("TrueNode");
    }
}
