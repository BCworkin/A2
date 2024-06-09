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
	public Node tail =  null;
	private int size;
	
	//Empty constructor for DSEList
	public DSEList() {
	}
	
	// DSEList constructor that accepts a node and sets it as head
	public DSEList(Node head_) {
		this.head = head_;
        this.tail = getTail(head_);        
        this.size = getSize(head_);
    }

    //method to calculate the size of the list from a given node
    private int getSize(Node node) {
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    //method to get the tail of the node
    private Node getTail(Node node) {
        if (node == null) {
            return null;
        }
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

	
	//takes a list then adds each element into a new list
	public DSEList(DSEList other) { 
	       if (other == null) {
	            return;
	        }

	        Node current = other.head;
	        while (current != null) {
	            this.add(current.getString());
	            current = current.next;
	        }
	}

	//remove the String at the parameter's index
	public String remove(int index) {
		
		if(index  < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		} 
		String returnString = null;
	    if (size == 1) {
	    	returnString = head.getString();
	        head = tail = null;
	        } else if (index == 0) {
	        	returnString = head.getString();
	            head = head.next;
	            head.prev = null;
	        } else if (index == size - 1) {
	            returnString = tail.getString();
	            tail = tail.prev;
	            tail.next = null;
	        } else {
	        	Node current;
	            if (index < size / 2) {
	                current = head;
	                for (int i = 0; i < index; i++) {
	                    current = current.next;
	                }
	            } else {
	                current = tail;
	                for (int i = size - 1; i > index; i--) {
	                    current = current.prev;
	                }
	            }
	            returnString = current.getString();
	            current.prev.next = current.next;
	            current.next.prev = current.prev;
	        }
	        size--;
	        return returnString;
	    }

	//returns the index of the String parameter 
	public int indexOf(String obj) {
		
		Node current = head;
		
		int index = 0;
		
		while (current != null) {
			if (current.getString().equals(obj)) {
				return index;
			}
			current = current.next;
			index++;
		}
		return -1;
	}
	
   //returns String at parameter's index
   public String get(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
        Node current = head;
        for (int i = 0; i < index; i++) {
        	current = current.next;
        }
        return current.getString();
        }
    }
	

	//checks if there is a list
	public boolean isEmpty() {
		Node current = head;
		if (current == null) {
			return true;
		} else {
			return false;
		}
	}

	//return the size of the list
	public int size() {
		return size;
	}
	
	//Take each element of the list a writes them to a string 
	@Override
	public String toString() {
		
		String output = "";
		
		Node current = head;
		while (current != null) {
			output = output.concat(current.getString());
			if (current.next != null) {
                output = output.concat(" ");
			}
            current = current.next;
		}
        output = output.concat("");
        return output;
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
	        Node current = head;
	        for (int i = 0; i < index - 1; i++) {
	            current = current.next;
	        }
	        newNode.next = current.next;
	        newNode.prev = current;
	        if (current.next != null) {
	        	current.next.prev = newNode;
	        }
	        current.next = newNode;
	    }

	    size++;
	    return true;

	}

	//searches list for parameter's String return true if found
	public boolean contains(String obj) {
        Node current = head;
        while (current != null) {
            if (current.getString().equals(obj)) {
                return true;
              
            } else {
                current = current.next;
            }
        }
        return false;
    }


	//removes the parameter's String form the list
	public boolean remove(String obj) {
		Node current = head;
		while (current != null) {
			if (current.getString().equals(obj)) {
				if (current == head) {
					head = current.next;
					if (head != null) {
						head.prev = null;
					 } 
				} else if (current == tail) {
                    tail = current.prev;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else {
                    current.next.prev = current.prev;
                    current.prev.next = current.next;
                }

                size--;
                return true;
            }
            current = current.next;
        } return false;
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
