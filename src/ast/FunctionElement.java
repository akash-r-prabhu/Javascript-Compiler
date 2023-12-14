package ast;

public class FunctionElement extends ElementBase implements ASTNode {
	FunctionBase node;
	public FunctionElement(FunctionBase node) {
		super();
		this.node = node;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("FunctionElement:");
		node.print();

	}

}
