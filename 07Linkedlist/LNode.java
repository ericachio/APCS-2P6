public class LNode<T>{

    private T data;
    private LNode<T> next;

    public String name(){
	return "chio.erica";
    }

    public LNode(){

    }
    
    public LNode(T n){
	data = n;
    }

    public LNode(T n, LNode<T> o){
	data = n;
	next = o;
    }
    
    public T getData(){
	return data;
    }
    
    public void setData(T n){
	data = n;
    }
    
    public LNode<T> getNext(){
	return next;
    }
    
    public void setNext(LNode<T> o){
	next = o;
    }

}
