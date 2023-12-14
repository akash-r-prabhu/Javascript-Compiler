// AssignStm.java
package ast;

public class AssignStm implements ASTNode {
    private String id;
    private ASTNode exp;

    public AssignStm(String id, ASTNode exp) {
        this.id = id;
        this.exp = exp;
    }

    @Override
    public void print() {
        System.out.println("AssignStm:");
        System.out.println("├─ ID: " + id);
        System.out.println("└─ Expression:");
        exp.print();
    }
}


