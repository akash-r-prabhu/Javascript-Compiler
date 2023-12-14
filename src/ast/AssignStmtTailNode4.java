
package ast;

public class AssignStmtTailNode4 extends AssignTail implements ASTNode {
	String content;

 public AssignStmtTailNode4(String content) {
     this.content = content;
 }

 @Override
 public void print() {
     System.out.println("AssignStmtTailNode4: (" + content);
 }
}
