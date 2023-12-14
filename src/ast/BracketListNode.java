package ast;

public class BracketListNode extends FactorBase implements ASTNode {
	ListBase list;

    public BracketListNode(ListBase list) {
        this.list = list;
    }

    @Override
    public void print() {
        System.out.println("BracketListNode:");
        list.print();
    }
}
