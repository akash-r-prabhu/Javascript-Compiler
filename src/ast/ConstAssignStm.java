package ast;

public class ConstAssignStm extends AssignBase implements ASTNode {
    private String id;
    ExpBase exp;

    public ConstAssignStm(String id, ExpBase exp) {
        this.id = id;
        this.exp = exp;
    }

    @Override
    public void print() {
        System.out.println("ConstAssignStm:");
        System.out.println("├─ ID: " + id);
        System.out.println("└─ Expression:");
        exp.print();
    }
}
