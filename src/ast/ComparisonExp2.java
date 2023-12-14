package ast;

public class ComparisonExp2 extends LogicalExpBase implements ASTNode {

	ComparisonBase node;
	public ComparisonExp2(ComparisonBase node) {
		super();
		this.node = node;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
        System.out.println("ComparsionExp2:");
        System.out.println("├─ :");
        node.print();
	}

}
