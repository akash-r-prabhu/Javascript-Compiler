package ast;

public class PrintStm extends Stm implements ASTNode {

	ASTNode t1; // ExpList
	
	public PrintStm(ASTNode t1) {
		super();
		this.t1 = t1;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		//Formatting the output for readability
		System.out.println("new PrintStm(");
		t1.print();
		System.out.println(")");

	}
}
