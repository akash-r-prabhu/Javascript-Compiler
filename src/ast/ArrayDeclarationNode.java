package ast;

public class ArrayDeclarationNode extends ArrayDeclBase implements ASTNode {
	
	public String id;
	ArrayElementsBase argument;

	public ArrayDeclarationNode(String id,ArrayElementsBase argument) {
		this.id = id;
		this.argument = argument;
	}
	
	public ArrayDeclarationNode(String id) {
		this.id = id;
	}
	
	@Override
	public void print() {
		System.out.println("ArrayDeclarationNode");
		System.out.println("ID : " + id);
		if (argument != null) {
			argument.print();
		}
	}

}
