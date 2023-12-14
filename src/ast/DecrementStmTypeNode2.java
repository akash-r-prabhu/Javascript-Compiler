// DecrementStmTypeNode.java
package ast;

public class DecrementStmTypeNode2 extends DecStmTypeBase implements ASTNode {
	PreDecBase decrementStmType;

    public DecrementStmTypeNode2(PreDecBase decrementStmType) {
        this.decrementStmType = decrementStmType;
    }

    @Override
    public void print() {
        decrementStmType.print();
    }
}
