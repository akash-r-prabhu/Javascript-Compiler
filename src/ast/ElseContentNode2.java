package ast;

public class ElseContentNode2 extends elseContentBase implements ASTNode {

	Statement t1;
	ElsePartBase t2;
	public ElseContentNode2(Statement t1, ElsePartBase t2) {
		super();
		this.t1 = t1;
		this.t2 = t2;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Else Content Node 2:");
		  if (t1 != null) {
	            System.out.println("├─ Statements:");
	            t1.print();
	        }
	        if (t2 != null) {
	            System.out.println("└─ ElsePart:");
	            t2.print();
	        }
	}

}
