package ast;

public class OpExp extends Exp implements ASTNode {

	ASTNode t1,t2; 
	int op;
	
	// Retain the order Exp intOp Exp
	public OpExp(ASTNode t1, int op, ASTNode t2) {
		super();
		this.t1 = t1;
		this.t2 = t2;
		this.op = op;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		//Formatting the output for readability
		System.out.println("new OpExp( ");
		t1.print();
		System.out.println(",");
		switch(op) {
		case 1:
			System.out.println("PLUS, ");
			break;
		case 2:
			System.out.println("MINUS, ");
			break;
		case 3:
			System.out.println("TIMES, ");
			break;
		case 4:
			System.out.println("DIV, ");
			break;
		}
		t2.print();
		System.out.println(")");

	}
}
