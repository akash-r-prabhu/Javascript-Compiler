package ast;

public class IdArguments extends ArgumentBase implements ASTNode {
	
	public String id;
	ArgumentBase argument;
	
	public IdArguments(String id) {
		this.id = id;
	}
	
	public IdArguments(String id, ArgumentBase argument) {
		this.id = id;
		this.argument = argument;
	}
	
	@Override
	public void print() {
		System.out.println("	└─ Arguments");
		System.out.println("		└─ ID: " + id);
		if(argument != null) {
			argument.print();
		}
	}
}