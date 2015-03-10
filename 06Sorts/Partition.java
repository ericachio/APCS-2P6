import java.util.Random;
import java.util.ArrayList;

public class Partition{

    public static int quicksort(int[] array, int num){
	int first = 0;
	int last = array.length;
	int k = num - 1;
	int pivot;
	while (first <= last){
	    pivot = partition(array, first, last);
	    if (pivot == k){
		return array[pivot];
	    }else if (pivot > k){
		last = pivot - 1;
	    }else {
		first = pivot + 1;
	    }
	}
	return 0;
    }

    public static int partition(int[] array, int si, int ei){
	Random rand = new Random();
	int pivot = array[(ei + si) / 2];
	int left = si;
	int right = ei - 1;
	while (left < right){
	    while (array[left] <= pivot && left < right){
		left++;
	    }
	    while (array[right] > pivot){
		right--;
	    }
	    if (left < right){
		swap(array, left, right);
	    }
	}
	//System.out.println(pivot);
	swap(array, si, right);
	return right;
    }

    public static void swap(int[] array, int x, int y){
	int temp = array[x];
	array[x] = array[y];
	array[y] = temp;
    }

    public static int[] randArray(int size){
	int[] intial = new int[size];
	for (int i = 0; i < intial.length; i++){
 	    intial[i] = i;
	}
	Random rand = new Random();
	for (int j = intial.length - 1; j > 0; j--){
	    int index = rand.nextInt(j + 1);
	    int a = intial[index];
	    intial[index] = intial[j];
	    intial[j] = a;
	}
	return intial;
    }

    public static String toString(int[] array){
	String ans = "";
	for (int i = 0; i < array.length; i++){
	    ans+= array[i] + ",";
	}
	return ans;
    }
    
    public static void main(String[]args){
	int[] yo = randArray(10);
	System.out.println(toString(yo));
	System.out.println(quicksort(yo, 5));
	//System.out.println(partition(yo, 0, 9));
	System.out.println(toString(yo));
    }
}
