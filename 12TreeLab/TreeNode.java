public class TreeNode<E>{

    private E data;
    private TreeNode<E> right, left;
    private TreeNode<E> next;
    

    public TreeNode(E stuff){
	data = stuff;
    }

    public TreeNode(E stuff, TreeNode<E> node){
	data = stuff;
	next = node;
    }
    
    public E getData(){
	return data;
    }
    public void setData(E value){
	data = value;
    }
    public TreeNode<E> getNext(){
	return next;
    }
    public void setNext(TreeNode<E> node){
	next = node;
    }
    public TreeNode<E> getRight(){
	return right;
    }
    public void setRight(TreeNode<E> value){
	right = value;
    }
    public TreeNode<E> getLeft(){
	return left;
    }
    public void setLeft(TreeNode<E> value){
	left = value;
    }
}
