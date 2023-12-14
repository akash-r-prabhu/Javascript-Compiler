package ast;

public class NumExp extends Exp implements ASTNode {

	int num;
	
	public NumExp(int num) {
		super();
		this.num = num;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		//Formatting the output for readability
		System.out.println("new NumExp( NUM :  "+num+" )");


	}
}
