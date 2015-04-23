public class TreeNode<T>{

    private T data;
    private T right, left;
    private TreeNode<T> next;
    

    public TreeNode(T stuff){
	data = stuff;
    }

    public TreeNode(T stuff, TreeNode<T> node){
	data = stuff;
	next = node;
    }
    
    public T getData(){
	return data;
    }
    public void setData(T value){
	data = value;
    }
    public TreeNode<T> getNext(){
	return next;
    }
    public void setNext(TreeNode<T> node){
	next = node;
    }
    public T getRight(){
	return right;
    }
    public void setRight(T value){
	right = value;
    }
    public T getLeft(){
	return left;
    }
    public void setLeft(T value){
	left = value;
    }
}
