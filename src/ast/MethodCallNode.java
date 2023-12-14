// MethodCallNode.java
package ast;

public class MethodCallNode extends MethodCallBase implements ASTNode {
    private String objectID;
    private String methodName;
    MethodCallBase methodCallTail;

    public MethodCallNode(String objectID, String methodName, MethodCallBase methodCallTail) {
        this.objectID = objectID;
        this.methodName = methodName;
        this.methodCallTail = methodCallTail;
    }

    @Override
    public void print() {
        System.out.println("MethodCallNode:");
        System.out.println("  Object ID: " + objectID);
        System.out.println("  Method Name: " + methodName);
        methodCallTail.print();
    }
}

