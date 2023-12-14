package ast;

public class TermExp extends AdditiveExpBase implements ASTNode {

	TermBase node;
	public TermExp(TermBase node) {
		super();
		this.node = node;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("TermExpression :");
		node.print();

	}

}
