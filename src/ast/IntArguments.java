package ast;

public class IntArguments extends ArgumentBase implements ASTNode {

	public String number;
	ArgumentBase argument;
	
	public IntArguments(String number) {
		this.number = number;
	}
	
	public IntArguments(String number, ArgumentBase argument) {
		this.number = number;
		this.argument = argument;
	}
	
	@Override
	public void print() {
		System.out.println("	└─ Arguments");
		System.out.println("		└─ INT: " + number);
		if(argument != null) {
			argument.print();
		}
	}

}
