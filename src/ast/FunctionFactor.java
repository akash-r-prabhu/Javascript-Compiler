package ast;

public class FunctionFactor extends FactorBase implements ASTNode {
	FunctionBase node;
	public FunctionFactor(FunctionBase node) {
		super();
		this.node = node;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		 System.out.println("	└─FunctionFactor:");
		 node.print();

	}

}
