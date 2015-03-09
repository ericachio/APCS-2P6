import java.util.Random;
import java.util.ArrayList;

public class Partition{

    public static int quicksort(int[] array, int num){
	int start = 0;
	int end = array.length;
	partition(array, start, end);
	if (partition(array, start, end) > num - 1){
	    quicksort(array, num);
	}else if (partition(array, start, end) < num){
	    quicksort(array, num);
	}else{
	    return array[num];
	}
	return array[num] + 0;
    }

    public static int partition(int[] array, int si, int ei){
	Random rand = new Random();
	int i = rand.nextInt(ei) + si;
	System.out.println("i" + i);
	int pivot = array[i];
	int[] sub = new int[array.length];
	int subi = si;
	int sube = ei - 1;
	for (int j = si; j < ei; j++){
	    if (array[j] < pivot){
		sub[subi] = array[j];
		subi++;
	    }else if (array[j] > pivot){
		sub[sube] = array[j];
		sube--;
	    }
	}
	System.out.println(pivot);
	sub[subi] = pivot;
	for (int l = 0; l < ei; l++){
	array[l] = sub[l];
	}
	return subi;
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
	//partition(yo, 0, 5);
	System.out.println(toString(yo));
    }
}
