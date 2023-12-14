
package ast;

public class AssignStmtTailNode3 extends AssignTail implements ASTNode {
	FactorBase content;

 public AssignStmtTailNode3(FactorBase content) {
     this.content = content;
 }

 @Override
 public void print() {
     System.out.println("AssignStmtTailNode3: (");
     content.print();
 }
}
