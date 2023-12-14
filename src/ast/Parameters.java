package ast;

public class Parameters extends ParamBase implements ASTNode {
	
	public String argument1;
	CommaIDBase argument2;
	
	public Parameters(String argument1,CommaIDBase argument2) {
		this.argument1 = argument1;
		this.argument2 = argument2;
	}

	@Override
	public void print() {
		//System.out.println("	└─ Parameters:");
		System.out.println("		└─ID: "+ argument1);
		argument2.print();
	}
}
