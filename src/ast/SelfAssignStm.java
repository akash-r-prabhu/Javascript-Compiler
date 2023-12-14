package ast;

public class SelfAssignStm extends AssignBase implements ASTNode {

	SelfAssignBase t1;
	public SelfAssignStm(SelfAssignBase t1) {
		super();
		this.t1 = t1;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Self Assignement Stm :");
		t1.print();

	}

}
