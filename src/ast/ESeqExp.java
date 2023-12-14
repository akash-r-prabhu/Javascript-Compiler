package ast;

public class ESeqExp extends Exp implements ASTNode {

	ASTNode t1,t2; // t1 is Stm and t2 is Exp
	
	public ESeqExp(ASTNode t1, ASTNode t2) {
		super();
		this.t1 = t1;
		this.t2 = t2;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		//Formatting the output for readability
		System.out.println("new ESeqExp( ");
		t1.print();
		System.out.println(",");
		t2.print();
		System.out.println(")");

	}
}
