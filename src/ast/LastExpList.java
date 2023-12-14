package ast;

public class LastExpList extends ExpList implements ASTNode {

	ASTNode t1;
	
	public LastExpList(ASTNode t1) {
		super();
		this.t1 = t1;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		//Formatting the output for readability
		System.out.println("new LastExpList( ");
		t1.print();
		System.out.println(")");

	}
}
