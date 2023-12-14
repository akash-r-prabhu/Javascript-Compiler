package ast;

public class IdAssignStm extends AssignBase implements ASTNode {
    String id;
    AssignTail assignstm_tail;

    public IdAssignStm(String id, AssignTail assignstm_tail) {
        this.id = id;
        this.assignstm_tail = assignstm_tail;
    }

    @Override
    public void print() {
        System.out.println("IdAssignStm:");
        System.out.println("├─ ID: " + id);
        System.out.println("└─ AssignStm Tail:");
        assignstm_tail.print();
    }
}
