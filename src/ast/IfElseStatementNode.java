package ast;

public class IfElseStatementNode extends IfStmBase implements ASTNode {
	ExpBase condition;
    Statement trueBranch;
    ElsePartBase elseBranch;

    public IfElseStatementNode(ExpBase condition, Statement trueBranch, ElsePartBase elseBranch) {
        this.condition = condition;
        this.trueBranch = trueBranch;
        this.elseBranch = elseBranch;
    }

    @Override
    public void print() {
        System.out.println("IfElseStatementNode:");
        System.out.println("├─ Condition:");
        condition.print();
        System.out.println("├─ True Branch:");
        trueBranch.print();
        System.out.println("└─ Else Branch:");
        elseBranch.print();
    }
}