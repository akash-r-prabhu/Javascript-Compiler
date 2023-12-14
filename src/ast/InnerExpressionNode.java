package ast;

public class InnerExpressionNode extends InnerExpBase implements ASTNode {
    private String id;
    ArgsBase arguments;

    public InnerExpressionNode(String id, ArgsBase arguments) {
        this.id = id;
        this.arguments = arguments;
    }

    @Override
    public void print() {
        System.out.println("InnerExpressionNode:");
        System.out.println("ID: " + id);
        System.out.println("Arguments:");
        arguments.print();
    }
}
