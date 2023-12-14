// FactorNode.java
package ast;

public class FactorNode extends FactorBase implements ASTNode {
    // Assuming factors can be identifiers, literals, etc.
    private String factorContent;

    public FactorNode(String factorContent) {
        this.factorContent = factorContent;
    }

    @Override
    public void print() {
        System.out.println("	└─FactorNode:");
        System.out.println("		└─ Factor Content: " + factorContent);
    }
}
