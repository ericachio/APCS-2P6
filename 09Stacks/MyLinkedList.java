import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{

    private LNode<T> head;
    private LNode<T> tail;
    private int size;

    public String name(){
	return "chio.erica";
    }

    public MyLinkedList(){
	this(null);
    }

    public MyLinkedList(LNode<T> start){
	head = start;
	tail = head;
	size = 0;
    }

    public Iterator<T> iterator(){
	return new MyLinkedListIterator<T>(head);
    }
    
    public String toString(){
	String ans = "[";
	LNode<T> now = head;
	while (now != null){
	    ans += now.getData() + " ";
	    now = now.getNext();
	}
	return ans.substring(0, ans.length() - 1) + "]";
    }
    
    public boolean add(T value){
	LNode<T> now = head;
	if (size == 0){
	    head = new LNode<T>(value);
	    tail = head;
	}else{
	    while (now.getNext() != null){
		now = now.getNext();
	    }
	    now.setNext(new LNode<T>(value));
	}
	size++;
	return true;
    }

    public int size(){
	return size;
    }
    
    public boolean add(int index, T value){
	LNode<T> now = head;
	if (index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}else if(index == size()){
	    add(value);
	}else{
	    int i = 0;
	    while (i < index){
		now = now.getNext();
		i++;
	    }
	    now.setNext(new LNode<T>(now.getData(), now.getNext()));
	    now.setData(value);
	    size++;
	}
	return true;
    }
    
    public boolean remove(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	if (index == 0){
	    head = head.getNext();
	}else{
	    int i = 0;
	    LNode<T> now = head;
	    for (int l = 0; l < index - 1; l ++){
		now = now.getNext();
	    }
	    try{
		now.setNext(now.getNext().getNext());
	    }catch (NullPointerException e){
		now.setNext(null);
		tail = now;
	    }
	}
	size--;
	return true;
    }
    
    public int indexOf(T value){
	int i = 0;
	LNode<T> now = head;
	while( i < size()){
	    if (now.getData() == value){
		return i;
	    }
	    now = now.getNext();
	    i++;
	}
	return -1;
    }
    
    public void clear(){
	size = 0;
	head = new LNode<T>();
	tail = head;
    }

    
    public class MyLinkedListIterator<T> implements Iterator<T>{

	private LNode<T> current;
	
	public MyLinkedListIterator(LNode<T> info){
	    current = info;
	}

	
	public boolean hasNext(){
	    return current != null;
	}

	public T next(){
	    if(hasNext()){
		T data = current.getData();
		current = current.getNext();
		return data;
	    }
	    throw new NoSuchElementException();
	}
	
	public void remove(){
	    throw new UnsupportedOperationException();
	}
       
    }
    
}
