package ast;

public class OperatorAssignStm extends AssignBase implements ASTNode {
    private String id;
    private String operator;
    Stm2 stm;

    public OperatorAssignStm(String id, String operator, Stm2 stm) {
        this.id = id;
        this.operator = operator;
        this.stm = stm;
    }

 
    @Override
    public void print() {
        System.out.println("OperatorAssignStm:");
        System.out.println("├─ ID: " + id);
        System.out.println("├─ Operator: " + operator);
        System.out.println("└─ Statement:");
        stm.print();
    }
}
