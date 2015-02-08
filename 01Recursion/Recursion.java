import java.lang.*;
public class Recursion implements hw1{

    public String name(){
	return "Chio,Erica";
    }

    public int fact(int n) throws IllegalArgumentException {
	if (n < 0){
	    throw new IllegalArgumentException();
	}else{
	    return f(n, 1);
	}
    }

    public int f(int n, int ans){
	if (n == 0){
	    return ans;
	}else{
	    return f(n - 1, ans * n); 
	}
    }

    public int fib(int n) throws IllegalArgumentException {
	if (n < 0){
	    throw new IllegalArgumentException(); 
	}else if (n == 1 || n == 2){
	    return 1;
	}else if (n == 0){
	    return 0;
	}else{
	    return fib(n - 1) + fib(n - 2);
	}
    }

    public double sqrt(double n) throws IllegalArgumentException{
	if (n < 0){
	    throw new IllegalArgumentException();
	}else if (n == 0){
	    return 0;
	}else{
	    return sq(n, 1);
	}
    }

    public double sq(double n, double guess){
	double nguess = (n/guess + guess) / 2;
	double nsq = nguess * nguess;
	double dif = nsq - n;
	if (nsq != n){
	    if (dif < 1.0e-10){
		return nguess;
	    }
	    return sq(n, nguess);
	}else{
	    return nguess;
	}
    }
}
