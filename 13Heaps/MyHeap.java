import java.util.*;

public class MyHeap{

    public int[] heap;
    private int mode;
    private final int max = 0;
    private final int min = 1;
    
    public MyHeap(){
	heap = int[2];
	mode = max;

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
    
}
