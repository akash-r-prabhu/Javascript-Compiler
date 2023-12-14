package ast;

public class StatementsNode extends Statement implements ASTNode {
    Stm2 st;
    Statement statements;

    public StatementsNode(Stm2 st, Statement statements) {
        this.st = st;
        this.statements = statements;
    }

    @Override
    public void print() {
        System.out.println("StatementsNode:");
        if (st != null) {
            st.print();
        }
        if (statements != null) {
            statements.print();
        }
    }
}