// ExpNode.java
package ast;

public class ExpNode3 extends ExpBase implements ASTNode {
	MethodCallBase content;

    public ExpNode3(MethodCallBase content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println("	└─ExpNode3:");
        content.print();
    }
}
