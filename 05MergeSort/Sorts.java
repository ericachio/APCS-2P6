import java.util.ArrayList;
import java.util.Random;
public class Sorts{

    public static void mergesort(int[] a){
	if (a.length <= 1){
	    a = a;
	}else{
	    int[] one = new int[a.length / 2];
	    int[] two = new int[a.length - one.length];
	    for (int i = 0; i < one.length; i++){
		one[i] = a[i];
	    }
	    int l = 0;
	    for (int j = one.length; j < a.length; j++){
		two[l] = a[j];
		l++;
	    }
	    mergesort(one);
	    mergesort(two);
	    merge(one, two, a);
	}
    }

    public static int[] merge(int[] a, int[]b, int[] combined){
	int acount = 0;
	int bcount = 0;
	int count = 0;
	while (acount < a.length && bcount < b.length){
	    if(a[acount] < b[bcount]){
		combined[count] = a[acount];
		acount++;
	    }else{
		combined[count] = b[bcount];
		bcount++;
	    }
	    count++;
	}
	System.arraycopy(a, acount, combined, count, a.length - acount);
	System.arraycopy(b, bcount, combined, count, b.length - bcount);
	return combined;
    }

    public static String toString(int[] a){
	String ans = "";
	for (int i = 0; i < a.length; i++){
	    ans += a[i] + " ";
	}
	return ans;
    }

    public static int[] makeRandomArray(int size, int range){
	int[] random = new int[size];
	Random rand = new Random();
	for (int i = 0; i < size; i++){
	    random[i] = rand.nextInt(range);
	}
	return random;
    }

    public static void main(String[]args){
	int[] a = {2,5,11,3,1,4,8,10};
	int[] b = {1,3,5,9};
	int[] c = {5,4,2,1};
	int[] d = {1,2,3,1,2,3,3,2,1,3,2,1};
	int[] e = {1000000000, -100000, 34542, 56754};
	mergesort(a);
	mergesort(b);
	mergesort(c);
	mergesort(d);
	mergesort(e);
        System.out.println(toString(a));
	System.out.println(toString(b));
	System.out.println(toString(c));
	System.out.println(toString(d));
	System.out.println(toString(e));
    }
}
