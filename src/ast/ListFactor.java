package ast;

public class ListFactor extends FactorBase implements ASTNode {
	ListBase node;
	public ListFactor(ListBase node) {
		super();
		this.node = node;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("	└─ListFactor:");
		node.print();

	}

}
