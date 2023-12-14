package ast;

public class MethodCallStm extends AssignBase implements ASTNode {

	MethodCallBase t1;
	public MethodCallStm(MethodCallBase t1) {
		super();
		this.t1 = t1;
	}
	@Override
	public void print() {
		System.out.println("Method Call Stm :");
		t1.print();
		// TODO Auto-generated method stub

	}

}
