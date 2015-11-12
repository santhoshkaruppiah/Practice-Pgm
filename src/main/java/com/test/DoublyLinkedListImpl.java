package com.test;

public class DoublyLinkedListImpl<T> {
	
	public DoublyLink<T> first;
	public DoublyLink<T> last;
	
	public void addFront(T data){
		
		DoublyLink<T> newLink = new DoublyLink<T>(data);
		
		if (first==null){
			last 	 	 =  newLink;
		}else{
			first.previous = newLink;
		}
		newLink.next   = first;
		first 		   = newLink;
	}
	
	public void addRear(T data){
		
		DoublyLink<T> newLink = new DoublyLink<T>(data);
		
		if (first == null){
			first 	 	 =  newLink;
		}else {
			last.next = newLink;
			newLink.previous = last;
		}
		
		last = newLink;
	}
	
	public void printForwardDoublyLinkedList(){
		
		System.out.println("Display List forward");
		
		DoublyLink<T> temp = first;
			
		while (temp!=null){
			//temp.displayLink();
			temp.displayLinkData();
			temp = temp.next;
		}
		
	}
	
	public void printBackwardDoublyLinkedList(){
		System.out.println("Display List Backward");
		
		DoublyLink<T> temp = last;
		while (temp!=null){
			//temp.displayLink();
			temp.displayLinkData();
			temp = temp.previous;
		}
		
	}
	
	public boolean addAfter(T... args){
		
		if (args.length<2){
			return false;
		}
		
		DoublyLink<T> current = first;

		//find the link after which new data is to be inserted
		
		while(current.data!=args[1]){
			current = current.next;
			if (current == null){
				return false;
			}
		}
		//current holds the data to be find
		
		DoublyLink<T> newLink = new DoublyLink<T>(args[0]); //create new data
		
		if (current == last) {
			last = newLink;
		} else {
			newLink.next 		  = current.next;
			current.next.previous = newLink;
		}
		newLink.previous = current;
		current.next 	 = newLink;
		return true;
	}
	
	public boolean addBefore(T... args){
		
		if (args.length<2){
			return false;
		}
		
		DoublyLink<T> current = first;

		//find the link after which new data is to be inserted
		
		while(current.data!=args[1]){
			current = current.next;
			if (current == null){
				return false;
			}
		}
		//current holds the data to be find
		
		DoublyLink<T> newLink = new DoublyLink<T>(args[0]); //create new data
		
		newLink.next = current;
		newLink.previous = current.previous;
		current.previous = newLink;
		
		return true;
	}
	
	public boolean addBetween(T... args){
		
		return false;
	}
	
	public DoublyLink<T> find(T key){
		
		DoublyLink<T> current = first;
		
		while(current.data!=key){
			current = current.next;
		}
		return current;
	}
	
	public DoublyLink<T> deleteAtFront(){
		
		DoublyLink<T> current = first;
		
		if (current.next==null){
			last =null;
		}else{
			first.next.previous= null;
		}
		first = first.next;
		return current;
	}
	
	public DoublyLink<T> delete(T key){
		
		DoublyLink<T> current = first;
		
		while(current.data!=key){
			current = current.next;
			if (current ==null){
				return null;
			}
		}
		
		if (current==first){
			first = current.next;
		}else{
			current.previous.next = current.next; 
		}
		
		if (current==last){
			last = current.previous;
		}else{
			current.next.previous = current.previous;
		}
		
		return current;
	}
	
	public DoublyLink<T> deleteAtLast(){
		
		DoublyLink<T> temp = last;
		
		if (first.next==null){
			first= null;
		}else{
			last.previous.next = null;
		}
		
		last = last.previous;
		
		return temp;
	}
	
	
	public static void main(String[] args) {
		
		/*DoublyLinkedListImpl<Integer> doublyListObj = new DoublyLinkedListImpl<Integer>();
		doublyListObj.addFront(1);
		doublyListObj.printForwardDoublyLinkedList();
		doublyListObj.addFront(2);
		doublyListObj.printForwardDoublyLinkedList();*/
		
		DoublyLinkedListImpl<Integer> doublyRearListObj = new DoublyLinkedListImpl<Integer>();
		doublyRearListObj.addRear(1);
		//doublyRearListObj.printForwardDoublyLinkedList();
		doublyRearListObj.addRear(2);
		//doublyRearListObj.printForwardDoublyLinkedList();
		doublyRearListObj.addRear(3);
		doublyRearListObj.printForwardDoublyLinkedList();
		
		doublyRearListObj.printBackwardDoublyLinkedList();
	}
}

class DoublyLink<T> {
	
	public T data;
	public DoublyLink<T> next;
	public DoublyLink<T> previous;
	
	public DoublyLink(T data){
		this.data = data;
	}
	
	public void displayLink(){
		System.out.println("*** PRINT LINK VALUES ***");
		System.out.println("Data is="+data);
		
		if (next==null){
			System.out.println("Next is null");
		}else{
			System.out.println("Next Data Value is="+next.data);
		}
		
		if (previous==null){
			System.out.println("Previous Values is null");
		}else{
			System.out.println("Previous Data Value is="+previous.data);
		}
	}
	
	public void displayLinkData(){
		System.out.println("*** PRINT LINK DATA VALUE ALONE ***");
		System.out.println("Data is="+data);
	}
}