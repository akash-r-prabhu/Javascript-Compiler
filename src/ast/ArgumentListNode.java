package ast;



public class ArgumentListNode extends ArgListBase implements ASTNode {
	private ASTNode argument;
    private ASTNode argument1;

    public ArgumentListNode(ASTNode argument, ASTNode argument1) {
        this.argument = argument;
        this.argument1 = argument1;
    }
 
    public ArgumentListNode(ASTNode argument) {
        this.argument = argument;
    }
    
    @Override
    public void print() {
        System.out.println("ArgumentsList:");
        argument.print();
        if (argument1 != null) {
        	argument1.print();
        }
    }
}