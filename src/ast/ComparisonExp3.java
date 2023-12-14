package ast;

public class ComparisonExp3 extends ComparisonExpBase implements ASTNode {
	
	ComparisonBase node;
	public ComparisonExp3(ComparisonBase node) {
		super();
		this.node = node;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("ComparisonExp3 : ");
		System.out.println("├─ :");
	}

}
