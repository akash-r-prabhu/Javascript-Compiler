package ast;

public class ArgumentsNode2 extends ArgsBase implements ASTNode {
	FactorBase node;
	public ArgumentsNode2(FactorBase node) {
		super();
		this.node = node;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
	     System.out.println("ArgumentsNode:");
	        node.print();
	    
	}

}
