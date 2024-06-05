package unisa.dse.a2.students;

import unisa.dse.a2.interfaces.ListGeneric;

/**
 * @author simont
 *
 */
public class DSEListGeneric<E> implements ListGeneric {
	
	public NodeGeneric<E> head;
	private NodeGeneric<E> tail;
	private int size;

	public DSEListGeneric() {
		
	}
	public DSEListGeneric(NodeGeneric<E> head_) {
		this.head = head_;
        this.tail = getTail(head_);        
        this.size = getSize(head_);
	}
	
    //method to calculate the size of the list from a given node
    private int getSize(NodeGeneric<E> node) {
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    //method to get the tail of the node
    private NodeGeneric<E> getTail(NodeGeneric<E> node) {
        if (node == null) {
            return null;
        }
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

	
	//Takes a list then adds each element into a new list
	public DSEListGeneric(DSEList other) { // Copy constructor. 
	       if (other == null) {
	            return;
	        }

	        Node current = other.head;
	        while (current != null) {
	            this.add(current.getString());
	            current = current.next;
	        }
	}

	//remove and return the item at the parameter's index
	public void remove(int index) {
		if(index  < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		} 
	    if (size == 1) {
	        head = tail = null;
	        } else if (index == 0) {
	            head = head.next;
	            head.prev = null;
	        } else if (index == size - 1) {
	            tail = tail.prev;
	            tail.next = null;
	        } else {
	        	NodeGeneric<E> current;
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
	            current.prev.next = current.next;
	            current.next.prev = current.prev;
	        }
	        size--;
	    }
	

	//returns the index of the String parameter 
	public int indexOf(String obj) {
		NodeGeneric<E> current = head;
		
		int index = 0;
		
		while (current != null) {
			if (current.get().equals(obj)) {
				return index;
			}
			current = current.next;
			index++;
		}
		return -1;
	}
	
	//returns item at parameter's index
	public void get(int index) {
        if (index < 0 || index >= size) {
        } else {
        NodeGeneric<E> current = head;
        for (int i = 0; i < index; i++) {
        	current = current.next;
        }
        }
	}

	//checks if there is a list
	public boolean isEmpty() {
		NodeGeneric<E> current = head;
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
		
		NodeGeneric<E> current = head;
		while (current != null) {
			output = output.concat(current.get());
			if (current.next != null) {
                output = output.concat(" ");
			}
            current = current.next;
		}
        output = output.concat("");
        return output;
    }


	//add the parameter item at of the end of the list
	public boolean add(Object obj) {
		
        NodeGeneric<E> newNode = new NodeGeneric<>(null, null, obj);
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

	//add item at parameter's index
	public boolean add(int index, Object obj) {

		if (index < 0 || index > size) {
	        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	    }
		
	    NodeGeneric<E> newNode = new NodeGeneric(null, null, obj);

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
	public boolean contains(Object obj) {
	}

	//removes the parameter's item form the list
	public boolean remove(Object obj) {
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
