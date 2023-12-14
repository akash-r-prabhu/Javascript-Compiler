package ast;

import java.util.List;

public class CommaIDNode implements ASTNode {
    private List<String> ids;

    public CommaIDNode(List<String> ids) {
        this.ids = ids;
    }

    @Override
    public void print() {
        System.out.println("CommaIDNode:");
        for (String id : ids) {
            System.out.println("└─ " + id);
        }
    }
}
