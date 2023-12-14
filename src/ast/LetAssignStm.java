package ast;

public class LetAssignStm extends AssignBase implements ASTNode {
    String id;
    ExpBase exp;

    public LetAssignStm(String id, ExpBase exp) {
        this.id = id;
        this.exp = exp;
    }

    @Override
    public void print() {
        System.out.println("LetAssignStm:");
        System.out.println("├─ ID: " + id);
        System.out.println("└─ Expression:");
        exp.print();
    }
}

