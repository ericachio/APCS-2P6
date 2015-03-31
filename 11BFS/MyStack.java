import java.util.*;

public class MyStack<T>{

    private LNode<T> stack;

    public MyStack(){
	stack = new LNode<T>();
    }

    public T push(T item){
	LNode<T> now = stack;
	if (stack.getData() == null){
	    stack = new LNode<T>(item);
	    return item;
	}else{
	    while(now.getNext() != null){
		now = now.getNext();
	    }
	    now.setNext(new LNode<T>(item));
	    return item;
	}
    }

    
    public T pop(){
	LNode<T> now = stack;
	while(now.getNext().getNext() != null){
	    now = now.getNext();
	}
	T ans = now.getNext().getData();
	now.setNext(null);
	return ans;
    }
    
    public T peek(){
	LNode<T> now = stack;
	while(now.getNext() != null){
	    now = now.getNext();
	}
	return now.getData();
    }
    

    public boolean empty(){
	return stack.getData() == null;
    }

    public String toString(){
	String ans = "[ ";
	if (stack != null){
	    LNode<T> now = stack;
	    while(now.getNext() != null){
		ans += now.getData() + " ";
		now = now.getNext();
	    }
	    ans += now.getData() + " ";
	    return ans + "]";
	}else{
	    return ans + "]";
	}
    }
    
}
