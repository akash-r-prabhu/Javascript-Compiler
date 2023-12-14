package ast;

public class EmptyBracketNode extends FactorBase implements ASTNode {
    @Override
    public void print() {
        System.out.println("EmptyBracketNode");
    }
}
