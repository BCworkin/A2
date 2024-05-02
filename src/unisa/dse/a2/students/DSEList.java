package unisa.dse.a2.students;

import unisa.dse.a2.interfaces.List;
import java.util.*;

/**
 * @author simont
 *
 */
public class DSEList implements List {
	
	public Node head = null;
	private Node tail =  null;
	private int size = 0;

	public DSEList() {
	}
	
	public DSEList(Node head_) {
		head = head_;
	}
	
	//Takes a list then adds each element into a new list
	public DSEList(DSEList other) { // Copy constructor. 
		if (other.head == null) {
			this.head = null; 
		} else {
			Node othernode = other.head;
			Node copyNode = new Node(othernode);
			
			this.head = copyNode;
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
		}
		Node<String> node = getNode(index);
		return node.data;
		
	}

	//checks if there is a list
	public boolean isEmpty() {
	}

	//return the size of the list
	public int size() {
	}
	
	//Take each element of the list a writes them to a string 
	@Override
	public String toString() {
	}

	//add the parameter String at of the end of the list
	public boolean add(String obj) {
		add(size, obj);
		return true;
		
	}

	//add String at parameter's index
	public boolean add(int index, String obj) {
		listIterator(index).add(obj);
		}
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
