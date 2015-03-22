import java.util.*;

public class MyStack<T>{

    private LNode<T> stack;

    public T push(T item){
	LNode<T> now = stack;
	if (stack.getValue() == null){
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
	
    }

    public T peek(){

    }

    public boolean empty(){
	return stack.getValue() == null;
    }
}
