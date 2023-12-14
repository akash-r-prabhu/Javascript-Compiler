package ast;

public class ElementList extends ListBase implements ASTNode {

	ElementBase node;
	public ElementList(ElementBase node) {
		super();
		this.node = node;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("ElementList:");
		node.print();
	}

}
