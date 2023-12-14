// ExpNode.java
package ast;

public class ExpNode2 extends ExpBase implements ASTNode {
	ComparisonExpBase content;

    public ExpNode2(ComparisonExpBase content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println("	└─ExpNode2:");
        content.print();
    }
}
