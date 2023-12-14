package ast;

public class OptionalArgumentsNode1 extends OptArgBase implements ASTNode {
	ExpBase exp;
  

    public OptionalArgumentsNode1(ExpBase exp) {
        this.exp = exp;
    }

    @Override
    public void print() {
        System.out.println("OptionalArgumentsNode1:");
        exp.print();
    }
}