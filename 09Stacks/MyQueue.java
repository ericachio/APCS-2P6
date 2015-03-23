import java.util.*;

public class MyQueue<T>{

    private MyLinkedList<T> queue;
    
    
    public T enqueue(T item){
	return item;
    }

    public T dequeue(){
	MyLinkedList<T> now = queue;
	if (queue.getData() != null){
	    now = queue.getNext();
	    
	}
	T ans = now.getData();
	now.setData(null);
	return ans;
    }
}
