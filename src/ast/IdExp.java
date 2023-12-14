package ast;

public class IdExp extends Exp implements ASTNode {

	String id;
	
	public IdExp(String id) {
		super();
		this.id = id;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		//Formatting the output for readability
		System.out.println("new IdExp(ID :  "+id+" )");
	}
}
