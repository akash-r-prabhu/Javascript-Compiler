package ast;

public class CommaParameters extends CommaIDBase implements ASTNode {

	public String argument1;
	public ASTNode argument2;
	
	public CommaParameters(String argument1,ASTNode argument2) {
		this.argument1 = argument1;
		this.argument2 = argument2;
	}

	@Override
	public void print() {
		System.out.println("		└─ID: "+ argument1);
		argument2.print();
	}
}
