// SemicolonStatements.java
package ast;

public class SemicolonStatements extends Statement implements ASTNode {
    @Override
    public void print() {
        System.out.println(";");
    }
}
