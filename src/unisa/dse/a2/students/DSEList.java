package unisa.dse.a2.students;

import unisa.dse.a2.interfaces.List;
import unisa.dse.a2.students.Node;
import java.util.*;

/**
 * @author simont
 *
 */
public class DSEList implements List {
	
	public Node head = null;
	private Node tail =  null;
	private int size;
	
	//done
	public DSEList() {
	}
	
	//done
	public DSEList(Node head_) {
		this.head = head_;
		this.tail = head_;
		this.size = 1;
	}
	
	//Takes a list then adds each element into a new list
	//done
	public DSEList(DSEList other) { // Copy constructor. 
	       if (other == null) {
	            return;
	        }

	        Node current = other.head;
	        while (current != null) {
	            current = current.next;
	        }
	}

	//remove the String at the parameter's index
	public String remove(int index) {
	}

	//returns the index of the String parameter 
	public int indexOf(String obj) {

	}
	
	//returns String at parameter's index
	public String get(int index) {
		if(index  < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		} else {
			return 
		}
		
	}

	//checks if there is a list
	public boolean isEmpty() {
		size = 0;
		return true;
	}

	//return the size of the list
	//done
	public int size() {
		return size;
	}
	
	//Take each element of the list a writes them to a string 
	@Override
	public String toString() {
	}

	//add the parameter String at of the end of the list
	public boolean add(String obj) {
		
        Node newNode = new Node(null, null, obj);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
	}


	//add String at parameter's index
	public boolean add(int index, String obj) { 
		
		if (index < 0 || index > size) {
	        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	    }
		
	    Node newNode = new Node(null, null, obj);

	    if (index == 0) { 
	        newNode.next = head;
	        if (head != null) {
	            head.prev = newNode;
	        }
	        head = newNode;
	        if (tail == null) { 
	            tail = newNode;
	        }
	    } else if (index == size) { 
	        newNode.prev = tail;
	        if (tail != null) {
	            tail.next = newNode;
	        }
	        tail = newNode;
	        if (head == null) { 
	            head = newNode;
	        }
	    } else { 
	        Node temp = head;
	        for (int i = 0; i < index - 1; i++) {
	            temp = temp.next;
	        }
	        newNode.next = temp.next;
	        newNode.prev = temp;
	        if (temp.next != null) {
	            temp.next.prev = newNode;
	        }
	        temp.next = newNode;
	    }

	    size++;
	    return true;

	}

	//searches list for parameter's String return true if found
	public boolean contains(String obj) {
	}

	//removes the parameter's String form the list
	public boolean remove(String obj) {
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object other) {
		return true;
	}
	
}
