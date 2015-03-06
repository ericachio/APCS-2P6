import java.util.Random;

public class Partition{

    public static void partition(int[] array, int si, int ei){
	Random rand = new Random();
	int i = rand.nextInt(ei) + si;
	int pivot = array[i];
	int[] sub = new int[array.length];
	int subi = 0;
	int sube = sub.length - 1;
	for (int j = si; j < ei; j++){
	    if (array[j] < pivot){
		sub[subi] = array[j];
		subi++;
	    }else if (array[j] > pivot){
		sub[sube] = array[j];
		sube--;
	    }
	}
	sub[subi] = pivot;
	for (int l = 0; l < array.length; l++){
	    array[l] = sub[l];
	}
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
	partition(yo, 0, 10);
	System.out.println(toString(yo));
    }
}
