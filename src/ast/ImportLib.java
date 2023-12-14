package ast;

public class ImportLib extends ImportBase implements ASTNode {

	public String id;
	public String argument1;
	public String argument2;
	
	public ImportLib(String id, String argument1, String argument2) {
		this.id = id;
		this.argument1 = argument1;
		this.argument2 = argument2;
	}
	
	public ImportLib(String id, String argument2) {
		this.id = id;
		this.argument2 = argument2;
	}
	
	@Override
	public void print() {
		
		System.out.println("	└─Import Statement");
		System.out.println("		└─ ID:" + id);
		if(argument1 != null) {
			System.out.println("		└─ REQUIRE:" + argument1);
		}
		System.out.println("		└─ Library:" + argument2);
		
	}
}
