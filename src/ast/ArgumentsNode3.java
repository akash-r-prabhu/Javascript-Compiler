package ast;

public class ArgumentsNode3 extends ArgsBase implements ASTNode {
	FactorBase node;
	ArgsBase arg;
	public ArgumentsNode3(FactorBase node, ArgsBase arg) {
		super();
		this.node = node;
		this.arg = arg;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
	     System.out.println("ArgumentsNode:");
	        node.print();
	        arg.print();
	    
	}

}
