import java.util.*;

public class Driver{

    public static void main(String[]args){
	Maze a;
	if(args.length < 1){
	    a = new Maze("data1.dat");
	}else{
	    a = new Maze(args[0]);
	}
	a.clearTerminal();
	if (args.length > 1){
	    a.solveDFS(true);
	}else{
	    a.solveBFS(true);
	}
	System.out.println(Arrays.toString(a.solutionCoordinates()));
    }
}
