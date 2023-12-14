package ast;

public class FalseNode extends FactorBase implements ASTNode {
    @Override
    public void print() {
        System.out.println("FalseNode");
    }
}
