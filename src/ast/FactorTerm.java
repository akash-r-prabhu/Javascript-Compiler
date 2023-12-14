package ast;

public class FactorTerm extends TermBase implements ASTNode {
	FactorBase node;
	public FactorTerm(FactorBase node) {
		super();
		this.node = node;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Factor term : ");
		node.print();
	}

}
