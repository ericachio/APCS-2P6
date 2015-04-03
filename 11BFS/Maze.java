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
    //private MyDeque<Integer> queue;
    //private MyStack<Integer> stack;

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

    private String go(int x,int y){
	return ("["+x+";"+y+"H");
    }
    
    private String clear(){
	return  "[2J";
    }
    
    private String hide(){
	return  "[?25l";
    }
    
    private String show(){
	return  "[?25h";
    }
    private String invert(){
	return  "[37";
    }
    
    public void clearTerminal(){
	System.out.println(clear());
    }
    
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    
    public String toString(){
	String ans = ""+maxx+","+maxy+"\n";
	for(int i=0;i<maxx*maxy;i++){
	    if(i%maxx ==0 && i!=0){
		ans+="\n";
	    }
	    ans += maze[i%maxx][i/maxx];
	}
	return hide()+invert()+go(0,0)+ans+"\n"+show();
    }
    
    
    public Coordinates findS(){
	Coordinates s;
	for (int i = 0; i < maze.length; i++){
	    for (int j = 0; j < maze[0].length; j++){
		if (maze[i][j] == 'S'){
		    s = new Coordinates(i, j);
		    return s;
		}
	    }
	}
	return s = new Coordinates(0,0);
    }

    private class Frontier{

	public Frontier(int mode){
	    if (mode == 0){
		solveBFS();
	    }else if (mode == 1){
		solveDFS();
	    }
	}
	public void add(){
	    
	}
	public void remove(){

	}
	
    }
    
    public boolean solve(boolean animate, int mode){
	Frontier nexts = new Frontier(mode);
	return false;
    }

    public boolean solveBFS(){
	return false;
    }

    public boolean solveDFS(){
	return false;
    }
}
