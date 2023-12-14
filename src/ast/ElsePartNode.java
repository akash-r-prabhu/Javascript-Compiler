// ElsePartNode.java
package ast;

public class ElsePartNode extends ElsePartBase implements ASTNode {
	elseContentBase elseContent;

    public ElsePartNode(elseContentBase elseContent) {
        this.elseContent = elseContent;
    }

    @Override
    public void print() {
        System.out.println("ElsePartNode:");
        elseContent.print();
    }
}
