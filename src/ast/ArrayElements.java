package ast;

public class ArrayElements extends ArrayElementsBase implements ASTNode {
	
	public ASTNode argument;
	public ASTNode argument1;
	
	public ArrayElements(ASTNode argument){
		this.argument = argument;
	}
	
	public ArrayElements(ASTNode argument,ASTNode argument1){
		this.argument = argument;
	}
	
	@Override
	public void print() {
		System.out.println("ArrayElements");
		argument.print();
		if (argument1 != null) {
			argument1.print();
		}
	}

}
