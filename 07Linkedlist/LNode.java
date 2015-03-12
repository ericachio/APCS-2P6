public class LNode{

    private LNode next;
    private int data;

    public LNode(int data){
	this.data = data;;
    }
    
    public int getData(){
	return data;
    }
    public void setData(int data){
	this.data = data;
    }
    public LNode getNext(){
	return next;
    }
    public void setNext(LNode next){
	this.next = next;
    }
    public String toString(){
	String ans = "[";
	LNode temp = next;
	while(next != null){
	    ans += temp.getData();
	    next = next.getNext();
	}
	return ans.substring(0, ans.length() - 1) + "]";
    }
    
}
