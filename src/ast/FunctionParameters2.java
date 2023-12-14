package ast;

public class FunctionParameters2 extends ParamListBase implements ASTNode {
	
	ParamBase argument1;
	NomEmptyParamBase argument2;
	@Override
	public void print() {
		System.out.println("	└─ Parameters:");
		argument1.print();
		argument2.print();
	}
	public FunctionParameters2(ParamBase argument1, NomEmptyParamBase argument2) {
		super();
		this.argument1 = argument1;
		this.argument2 = argument2;
	}
}