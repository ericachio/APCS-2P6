import java.util.*;

public class MyQueue<T>{

    private MyLinkedList<T> queue;


    public MyQueue(){
	queue = new MyLinkedList<T>();
    }
    
    public T enqueue(T item){
	queue.add(item);
	return true;
    }

    public T dequeue(){
	return queue.remove(0);
    }
}
