package ast;

public class ExpFactor extends FactorBase implements ASTNode {
	ExpBase node;
	public ExpFactor(ExpBase node) {
		super();
		this.node = node;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
        System.out.println("Expression Factor:");
        System.out.println("└─ :");
        node.print();

	}

}
