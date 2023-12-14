package ast;

public class ArrayAccessDer extends FactorBase implements ASTNode {
	
	ArrayAccessBase node;
	public ArrayAccessDer(ArrayAccessBase node) {
		super();
		this.node = node;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("	└─ArrayAccess:");
		node.print();
	}

}
