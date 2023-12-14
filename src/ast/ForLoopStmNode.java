package ast;

public class ForLoopStmNode extends ForLoopBase implements ASTNode {
	Stm2 initStm;
	Stm2 condition;
	Stm2 updateStm;
	Statement statements;

    public ForLoopStmNode(Stm2 initStm, Stm2 condition, Stm2 updateStm, Statement statements) {
        this.initStm = initStm;
        this.condition = condition;
        this.updateStm = updateStm;
        this.statements = statements;
    }

    @Override
    public void print() {
        System.out.println("ForLoopStmNode:");
        System.out.println("├─ Initialization:");
        initStm.print();
        System.out.println("├─ Condition:");
        condition.print();
        System.out.println("├─ Update:");
        updateStm.print();
        System.out.println("└─ Statements:");
        statements.print();
    }
}
