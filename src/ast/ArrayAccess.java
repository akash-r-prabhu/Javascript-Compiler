package ast;

public class ArrayAccess extends ArrayAccessBase implements ASTNode {
	
	public String id;
	ExpBase exp;
	
	public ArrayAccess(String id, ExpBase exp) {
		this.id = id;
		this.exp = exp;
	}

	@Override
	public void print() {
		System.out.println("ArrayAccess");
		System.out.println("├─ ID: " + id);
        System.out.println("└─ Expression:");
        exp.print();
	}

}
