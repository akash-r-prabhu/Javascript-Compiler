package ast;

import java.util.List;

public class ParamNode implements ASTNode {
    private String id;
    private List<String> commaId;

    public ParamNode(String id, List<String> commaId) {
        this.id = id;
        this.commaId = commaId;
    }

    @Override
    public void print() {
        System.out.println("ParamNode: " + id);
        for (String id : commaId) {
            System.out.println("  " + id);
        }
    }
}