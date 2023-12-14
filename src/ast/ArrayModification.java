package ast;

public class ArrayModification extends ArrayModifyBase implements ASTNode {
	
	public String id;
	ExpBase exp1;
	ExpBase exp2;
	
	public ArrayModification(String id, ExpBase exp1, ExpBase exp2) {
		this.id = id;
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
	
	
	@Override
	public void print() {
		System.out.println("ArrayModification");
		System.out.println("	└─ ID :" + id);
		exp1.print();
		exp2.print();

	}

}
