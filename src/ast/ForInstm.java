// ForInstmNode.java
package ast;

public class ForInstm extends ForInStmBase implements ASTNode {
	ForInLoopBase forInLoopExpr;
	Stm2 stm;

    public ForInstm(ForInLoopBase forInLoopExpr, Stm2 stm) {
        this.forInLoopExpr = forInLoopExpr;
        this.stm = stm;
    }

    @Override
    public void print() {
        System.out.println("ForInstm:");
        System.out.println("├─ ForInLoopExpr:");
        forInLoopExpr.print();
        System.out.println("└─ Statement:");
        stm.print();
    }
}
