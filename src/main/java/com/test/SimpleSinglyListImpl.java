package com.test;

public class SimpleSinglyListImpl<T> {

	Link<T> root;
	
	/**
	 * 
	 * @param data
	 */
	public void addFront(T data){
		Link<T> newLink = new Link<T>(data);
		newLink.next = root;
		root = newLink;
	}
	
	public void addRear(T data){
		
		if (root==null){
			Link<T> newLink = new Link<T>(data);
			newLink.next = root;
			root = newLink;
		}else{
			Link<T> newLink = new Link<T>(data);
			Link<T> temp = root;
			int counter = 0;
			while(temp.next!=null){
				temp = temp.next;
				counter++;
			}
			System.out.println(counter+",  hop to insert one data");
			temp.next = newLink;
		}
	}
	
	public Link deleteFirst(){
		Link<T> temp = root;
		root = root.next;
		return temp;
	}
		
	public void printList(){
		
		Link temp = root;
		System.out.println("****Current Stack Values****");
		while (temp!=null) {
			System.out.println("Value = "+temp.data);
			temp = temp.next;
		}
	}
	
	public  Link<T> find(T key)  {
		
		Link<T> current = root;
		
		while(current.data!=key){
			if (current.next ==null){
				return null;
			}else {
				current = current.next;
			}
		}
		
		return current;
	}
	
	public Link<T> delete(T key)  {
		Link<T> current = root;
		Link<T> previous = root;
		
		while(current.data!=key){
			if (current.next==null){
				return null;
			}else {
				previous = current;
				current = current.next;
			}
		}
		
		if (current==root) {
			root = root.next;
		}else{
			previous.next = current.next;
		}
		return current;
	}
	
	public static void main(String[] args) {
		SimpleSinglyListImpl<Integer> frontDemoList = new SimpleSinglyListImpl<Integer>();
		frontDemoList.addFront(1);
		frontDemoList.addFront(2);
		frontDemoList.addFront(3);
		frontDemoList.printList();
		Link<Integer> frontFirstdelete = frontDemoList.deleteFirst();
		frontFirstdelete.displayLink();
		Link<Integer> deleted = frontDemoList.delete(2);
		deleted.displayLink();
		frontDemoList.printList();
		Link<Integer> findNode = frontDemoList.find(1);
		System.out.println("Found item is::"+findNode.data);
		frontDemoList.addFront(4);
		frontDemoList.printList();
		System.out.println();
		
		SimpleSinglyListImpl<String> rearDemoList = new SimpleSinglyListImpl<String>();
		rearDemoList.addRear("One");
		rearDemoList.addRear("two");
		rearDemoList.addRear("three");
		rearDemoList.addRear("four");
		rearDemoList.printList();
		Link<String> reardeleted = rearDemoList.delete("two");
		reardeleted.displayLink();
		rearDemoList.printList();
		Link<String> rearFirstdeleted = rearDemoList.deleteFirst();
		reardeleted.displayLink();
		rearDemoList.addRear("five");
		rearDemoList.printList();

	}

	public Link<T> getRoot() {
		return root;
	}
	
}


class Link<T>{
	
    public T data; //the data stored in this node
    public Link<T> next; //store a reference to the next node in this singlylinkedlist
    
    public Link(T data){
        this.data = data;
        //this.next = next;
    }
    
    public void displayLink(){
    	System.out.println("~~~ Link Values~~~");
    	System.out.println("Data is="+data);
    	if (next==null){
    		System.out.println("Next value is null");
    	}else{
    		System.out.println("Next value is "+next.data);
    	}
    }
}