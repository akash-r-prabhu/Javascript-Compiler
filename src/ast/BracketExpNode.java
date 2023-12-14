package ast;

public class BracketExpNode extends FactorBase implements ASTNode {
	ExpBase exp;

    public BracketExpNode(ExpBase exp) {
        this.exp = exp;
    }

    @Override
    public void print() {
        System.out.println("BracketExpNode:");
        exp.print();
    }
}
