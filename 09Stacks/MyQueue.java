import java.util.*;

public class MyQueue<T>{

    private MyLinkedList<T> queue;


    public MyQueue(){
	queue = new MyLinkedList<T>();
    }
    
    public boolean enqueue(T item){
	queue.add(item);
	return true;
    }

    public boolean dequeue(){
	return queue.remove(0); 
    }
}
