// DecrementStmTypeNode.java
package ast;

public class DecrementStmTypeNode extends DecStmTypeBase implements ASTNode {
	PostDecBase decrementStmType;

    public DecrementStmTypeNode(PostDecBase decrementStmType) {
        this.decrementStmType = decrementStmType;
    }

    @Override
    public void print() {
        decrementStmType.print();
    }
}
