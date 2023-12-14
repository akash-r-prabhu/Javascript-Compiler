// ExpNode.java
package ast;

public class ExpNode4 extends ExpBase implements ASTNode {
	LogicalExpBase content;

    public ExpNode4(LogicalExpBase content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println("	└─ExpNode4:");
        content.print();
    }
}
