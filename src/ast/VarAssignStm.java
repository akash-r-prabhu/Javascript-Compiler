package ast;

public class VarAssignStm extends AssignBase implements ASTNode {

	VarAssignBase t1;
	public VarAssignStm(VarAssignBase t1) {
		super();
		this.t1 = t1;
	}
	@Override
	public void print() {
		System.out.println("VariableAssignStm : ");
		t1.print();
		// TODO Auto-generated method stub

	}

}
