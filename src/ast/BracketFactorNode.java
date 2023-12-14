package ast;

public class BracketFactorNode extends FactorBase implements ASTNode {
    FactorBase factor;

    public BracketFactorNode(FactorBase factor) {
        this.factor = factor;
    }

    @Override
    public void print() {
        System.out.println("BracketFactorNode: (");
        factor.print();
    }
}
