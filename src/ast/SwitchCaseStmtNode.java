package ast;

import java.util.List;

public class SwitchCaseStmtNode implements ASTNode {
    private ASTNode exp;
    private List<ASTNode> caseList;
    private ASTNode defaultCase;

    public SwitchCaseStmtNode(ASTNode exp, List<ASTNode> caseList, ASTNode defaultCase) {
        this.exp = exp;
        this.caseList = caseList;
        this.defaultCase = defaultCase;
    }

    @Override
    public void print() {
        System.out.println("SwitchCaseStmtNode:");
        System.out.print("Expression: ");
        exp.print();
        System.out.println("Cases:");
        for (ASTNode caseItem : caseList) {
            caseItem.print();
        }
        if (defaultCase != null) {
            System.out.println("Default:");
            defaultCase.print();
        }
    }
}