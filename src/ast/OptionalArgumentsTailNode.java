package ast;

public class OptionalArgumentsTailNode extends OptArgTailBase implements ASTNode {
	ExpBase exp;
	OptArgTailBase optionalArgumentsTail;

    public OptionalArgumentsTailNode(ExpBase exp, OptArgTailBase optionalArgumentsTail) {
        this.exp = exp;
        this.optionalArgumentsTail = optionalArgumentsTail;
    }

    @Override
    public void print() {
        System.out.println("OptionalArgumentsTailNode:");
        exp.print();
        optionalArgumentsTail.print();
    }
}