package ast;

public class FunctionCall extends FunctionCallBase implements ASTNode {
	
	public String id;
	ArgumentBase argument;
	
	public FunctionCall (String id,ArgumentBase argument) {
		this.id = id;
		this.argument = argument;
	}
	
	@Override
	public void print() {
		System.out.println("	└─FunctionCall");
		System.out.println("		└─ ID:" + id);
		argument.print();
	}
}
