import java.util.*;

public class MyDeque<T>{

    public Object[] list;
    public int head;
    public int tail;
    public int size;
    public int[] pri;
    public boolean pq;

    public int size(){
	return size;
    }

    public String name(){
	return "chio.erica";
    }
    
    public MyDeque(){
	this(false);
    }

    public MyDeque(boolean priority){
	list = new Object[10];
	head = 5;
	tail = 4;
	size = 0;
	pq = priority;
	if (pq){
	    pri = new int[10];
	}
    }

    public void resize(){
	if (size == list.length){
	    Object[] better = new Object[size * 2];
	    for (int i = 0; i < size; i++){
		better[i] = list[(head + 1) % size];
	    }
	    list = better;
	    head = 0;
	    tail = size - 1;
	}
    }
    
    public void addFirst(T value){
	resize();
	head--;
	if (head < 0){
	    head += list.length;
	}
	list[head] = value;
	size++;
    }
    public void addLast(T value){
	resize();
	tail++;
	if( tail != 0 && tail >= list.length){
	    tail -= list.length;
	}
	list[tail] = value;
	size++;
    }
    public T removeFirst(){
	T ans = (T) list[head];
	list[head] = null;
	head++;
	if (head >= list.length ){
	    head -= list.length;
	}
	size--;
	return ans;
    }
    public T removeLast(){
	T ans = (T) list[tail];
	list[tail] = null;
	tail--;
	if (tail < 0){
	    tail += list.length;
	}
	size--;
	return ans;
    }
    public T getFirst(){
	return (T) list[head];
    }
    public T getLast(){
	return (T) list[tail];
    }

    public boolean isEmpty(){
	return size == 0;
    }
    
    public void add(T stuff, int priority){
	addLast(stuff);
	pri[tail] = priority;
    }

    public void resizep(){
	if (size == pri.length){
	    int[] temp = new int[size * 2];
	    for (int i = 0; i < size; i++){
		temp[i] = pri[(head + 1) % size];
	    }
	    pri = temp;
	    head = 0;
	    tail = size - 1;
	}
    }

    public String toString(){
	String ans = "[ ";
	if (size != 0){
	    if (head <= tail){
		for (int i = head; i <= tail; i++){
		    if (list[i] != null){
			ans += list[i] + " ";
		    }
		}
	    }else{
		for (int i = head; i < list.length; i++){
		    if (list[i] != null){
			ans += list[i] + " ";
		    }
		}
		for (int j = 0; j <= tail; j++){
		    if (list[j] != null){
			ans += list[j] + " ";
		    }
		}
	    }
	}
	return ans += "]";
	    
    }
    
    public static void main(String[]args){
	/*
	MyDeque<Integer> a = new MyDeque<Integer>();
	a.addFirst(new Integer(10));
	System.out.println(a.getFirst());
	a.addFirst(new Integer(3));
	System.out.println(a.getFirst());
	a.addFirst(new Integer(5));
	System.out.println(a.getFirst());
	System.out.println(a.getLast());
	a.addLast(new Integer(4));
	System.out.println(a.getLast());
	*/
	MyDeque<Integer> b = new MyDeque<Integer>(true);
	//System.out.println(b);
	b.add(0,12);
	b.add(5,10);
	b.add(2,8);
	b.add(3,0);
	b.add(4,2);
	b.add(1,9);
	System.out.println(b.toString());
	//System.out.println(b.pri);
    }
}
