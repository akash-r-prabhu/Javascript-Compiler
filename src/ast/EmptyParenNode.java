package ast;

public class EmptyParenNode extends FactorBase implements ASTNode {
    @Override
    public void print() {
        System.out.println("EmptyParenNode");
    }
}
