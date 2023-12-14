package ast;

public class FunctionParameters1 extends ParamListBase implements ASTNode {
	
	EmptyParamBase argument1;
	public FunctionParameters1(EmptyParamBase argument1) {
		super();
		this.argument1 = argument1;
	}
	@Override
	public void print() {
		System.out.println("	└─ Parameters:");
		argument1.print();
	}
}
