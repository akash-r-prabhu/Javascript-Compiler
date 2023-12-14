// ExpNode.java
package ast;

public class ExpNode1 extends ExpBase implements ASTNode {
	FactorBase content;

    public ExpNode1(FactorBase content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println("	└─ExpNode1:");
        content.print();
    }
}
