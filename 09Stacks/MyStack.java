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

    /*
    public T pop(){
	
    }

    public T peek(){
       
    }
    */

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
    

    public static void main(String[]args){
	MyStack<Integer> a = new MyStack<Integer>();
	System.out.println(a.empty());
	a.push(4);
	System.out.println(a.empty());
	System.out.println(a.toString());
	for(int i = 0; i < 10; i++){
	    a.push(i);
	}
    }
}
