import java.util.*;
import java.io.*;

public class Maze{

    
    private class Coordinates{
	
	private int row, col;
	
	public Coordinates(int r, int c){
	    row = r;
	    col = c;
	}
	
	public int getR(){
	    return row;
	}
	
	public int getC(){
	    return col;
	}

	public String toString(){
	return "(" + row + ", " + col + ")"; 
	}
    }

    
    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;
    private MyDeque<Integer> queue;
    private MyStack<Integer> stack;

    public Maze(String filename){
	startx = -1;
	starty = -1;
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));
	    
	    //keep reading next line
	    while(in.hasNext()){
		String line= in.nextLine();
		if(maxy==0){
		    //calculate width of the maze
		    maxx=line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans+=line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: "+filename+" could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	
	maze = new char[maxx][maxy];
	for(int i=0;i<ans.length();i++){
	    char c = ans.charAt(i);
	    maze[i%maxx][i/maxx]= c;
	    if(c=='S'){
		startx = i%maxx;
		starty = i/maxx;
	    }
	}
    }   

    public boolean solveBFS(){
	
	return false;
    }
    
}
