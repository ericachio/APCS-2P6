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
    
    public void addFirst(T value){
	
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
