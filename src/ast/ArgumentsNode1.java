package ast;

public class ArgumentsNode1 extends ArgsBase implements ASTNode {
	ArgListBase argument;

    public ArgumentsNode1(ArgListBase argument) {
        this.argument = argument;
    }
 

    
    @Override
    public void print() {
        System.out.println("ArgumentsNode:");
        argument.print();
     
    }
}
