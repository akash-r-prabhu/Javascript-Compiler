package ast;

public class FunctionStatement extends FunctionBase implements ASTNode {
	
	public String id;
	ParamListBase argument1;
	Statement argument2;
	
	public FunctionStatement(String id,ParamListBase argument1,Statement argument2) {
		this.id = id;
		this.argument1 = argument1;
		this.argument2 = argument2;
	}
	
	public FunctionStatement(ParamListBase argument1,Statement argument2) {
		this.argument1 = argument1;
		this.argument2 = argument2;
	}
	
	public FunctionStatement(ParamListBase argument1) {
		this.argument1 = argument1;
	}
	
	@Override
	public void print() {
		System.out.println("	└─Function Statement");
		if(id != null) {
			System.out.println("		└─ ID:"+id);
		}
		argument1.print();
		if(argument2 != null) {
			argument2.print();
		}

	}

}
