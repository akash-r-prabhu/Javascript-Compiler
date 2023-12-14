package ast;

public class CompoundStm extends Stm implements ASTNode {
	ASTNode t1,t2;
	
	public CompoundStm(ASTNode t1, ASTNode t2) {
		super();
		this.t1 = t1;
		this.t2 = t2;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		//Formatting the output for readability
		System.out.println("new CompoundStm( ");
		t1.print();
		System.out.println(",");
		t2.print();
		System.out.println(")");

	}

}
