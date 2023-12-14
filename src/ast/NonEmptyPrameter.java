package ast;

public class NonEmptyPrameter extends NomEmptyParamBase implements ASTNode {
	
	ParamBase argument1;
	NomEmptyParamBase argument2;
	
	public NonEmptyPrameter(ParamBase argument1,NomEmptyParamBase argument2) {
		this.argument1 = argument1;
		this.argument2 = argument2;
	}

	@Override
	public void print() {
		System.out.println("NonEmptyPrameter");
		argument1.print();
		argument2.print();

	}

}
