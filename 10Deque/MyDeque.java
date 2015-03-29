import java.util.*;

public class MyDeque<T>{

    public Object[] list;
    public int head;
    public int tail;
    public int size;
    
    public MyDeque(){
	list = new Object[10];
	head = 1;
	tail = 0;
    }

    public void resize(){
	if (size = list.length){
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

    }
    public T removeFirst(){

    }
    public T removeLast(){

    }
    public T getFirst(){
	return (T) list[head];
    }
    public T getLast(){
	return (T) list[tail];
    }
    
}
