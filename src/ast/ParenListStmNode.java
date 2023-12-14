package ast;

public class ParenListStmNode extends FactorBase implements ASTNode {
	ListBase list;

    public ParenListStmNode(ListBase list) {
        this.list = list;
    }

    @Override
    public void print() {
        System.out.println("ParenListStmNode:");
        list.print();
    }
}
