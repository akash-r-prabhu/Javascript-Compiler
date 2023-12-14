package ast;

public class MethodCallTailNode2 extends MethodCallBase implements ASTNode {

	OptArgBase t1;
	Statement t2;
	public MethodCallTailNode2(OptArgBase t1, Statement t2) {
		super();
		this.t1 = t1;
		this.t2 = t2;
	}
	@Override
	public void print() {
		System.out.println("MethodCallTailNode2 : ");
		t1.print();
		t2.print();
		// TODO Auto-generated method stub

	}

}
