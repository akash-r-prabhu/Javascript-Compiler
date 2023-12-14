// ForInLoopExprNode.java
package ast;

public class ForInLoopExpr extends ForInLoopBase implements ASTNode {
    private String varType;
    private String id;
    private String inId;

    public ForInLoopExpr(String varType, String id, String inId) {
        this.varType = varType;
        this.id = id;
        this.inId = inId;
    }

    @Override
    public void print() {
        System.out.println("├─ VarType: " + varType);
        System.out.println("├─ ID: " + id);
        System.out.println("└─ InID: " + inId);
    }
}
