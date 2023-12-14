package ast;

public class OptionalArgumentsNode2 extends OptArgBase implements ASTNode {

	FactorBase node;
	OptArgTailBase tail;
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Optional Arg Nodes 2");
		node.print();
		tail.print();
	}
	public OptionalArgumentsNode2(FactorBase node, OptArgTailBase tail) {
		super();
		this.node = node;
		this.tail = tail;
	}

}
