public class LinkedList{

    private LNode head;
    private int data;

    public String toString(){
	String ans = "[";
	LNode temp = head;
	while (head != null){
	    ans += temp.getData();
	    head = head.getNext();
	}
	return ans.substring(0, ans.length() - 1) + "]";
    }
    public void add(int value){
	head.setData(value);
    }

    public void add(int index, int value){
	int now = 0;
	LNode temp = head;
	
    }
}
