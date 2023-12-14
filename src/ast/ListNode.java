// ListNode.java
package ast;

import java.util.List;

public class ListNode extends ListBase implements ASTNode {
    List<FactorBase> elements1;
    List<ListBase> elements2;

    public ListNode(List<FactorBase> elements1, List<ListBase> elements2) {
		super();
		this.elements1 = elements1;
		this.elements2 = elements2;
	}

	public ListNode() {
		super();
	}

	public void addElement(FactorBase element, ListBase lst) {
		if(element != null)
        this.elements1.add(element);
		if(lst != null)
		this.elements2.add(lst);
    }

    @Override
    public void print() {
        System.out.println("ListNode:");
        if(elements1 != null)
        for (FactorBase element : elements1) {
            element.print();
        }
        if(elements2 != null)
        for (ListBase element : elements2) {
            element.print();
        }
    }
}






