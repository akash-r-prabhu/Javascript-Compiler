package ast;

public class EmptyNode extends ArgsBase implements ASTNode {
    @Override
    public void print() {
        System.out.println("EmptyNode");
    }
}