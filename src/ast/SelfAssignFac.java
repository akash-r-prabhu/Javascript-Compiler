package ast;

public class SelfAssignFac extends FactorBase implements ASTNode {
	SelfAssignBase node;
	public SelfAssignFac(SelfAssignBase node) {
		super();
		this.node = node;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		 System.out.println("	└─Self Assign:");
		 node.print();
	}

}
