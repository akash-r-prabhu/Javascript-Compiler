// ListNode.java
package ast;

import java.util.ArrayList;
import java.util.List;

public class ListNode2 extends ListBase implements ASTNode {
    List<ElementBase> elements1;
    List<ListBase> elements2;
    public ListNode2(List<ElementBase> elements1, List<ListBase> elements2) {
		super();
		this.elements1 = elements1;
		this.elements2 = elements2;
	}


    public ListNode2() {
		super();
	}


	public void addElement(ListBase element,  ElementBase lst) {
    	if(element == null)
        this.elements2.add(element);
    	if(lst == null)
    	this.elements1.add(lst);
    }

    @Override
    public void print() {
        System.out.println("ListNode:");
        for (ElementBase element : elements1) {
            element.print();
        }
        for (ListBase element : elements2) {
            element.print();
        }
    }
}
