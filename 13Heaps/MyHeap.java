import java.util.*;

public class MyHeap{

    public int[] heap;
    private int mode;
    private final int max = 0;
    private final int min = 1;
    
    public MyHeap(){
	heap = int[10];
	mode = max;
    }

    public MyHeap(boolean isMax){
	heap = int[2];
	if (isMax){
	    mode = max;
	}else{
	    mode = min;
	}
    }

    public boolean compare(int p, int c){
	if(mode == max){
	    return p < c;
	}else if(mode == min){
	    return p > c;
	}
    }

    public void add(int n){
	heap[heap[0]+1] = value;
	heap[0] += 1;
	addH(heap[0]);
	resize();
    }

    public void addH(int index){
	if (index != 1 && compare(heap[index/2], heap[index])){
	    int temp = heap[index];
	    heap[index] = heap[index/2];
	    heap[index/2] = temp;
	    addH(index/2);
	}
    }
    
    public void resize(){
	if(heap[0] == heap.length - 1){
	    int[] newheap = new int[heap.length * 2];
	    for (int i = 0; i < heap.length; i++) {
		newheap[i] = heap[i];
	    }
	heap = newheap;
	}
    }

    public String toString(){
	String ans = "";
	for (int i = 1; i <= heap[0]; i++){
	    ans += heap[i] + " ";
	}
	return ans;
    }
    
    public static void main(String[] args){
	MyHeap a = new MyHeap(true);
	a.add(4);
	a.add(3);

	
    }
}
