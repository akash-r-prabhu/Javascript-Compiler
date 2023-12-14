package ast;

public class MethodCallArg extends MethodCallBase implements ASTNode {

	ArgsBase node;
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("MethodCallArg :");
		node.print();

	}
	public MethodCallArg(ArgsBase node) {
		super();
		this.node = node;
	}

}
