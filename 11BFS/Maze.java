import java.util.*;
import java.io.*;

public class Maze{

    //solveBFS() solveDFS() solveBest() solveAStar()
    
    private class Coordinates{
	
	private int row, col;
	
	public Coordinates(int r, int c){
	    row = r;
	    col = c;
	}
	
	public int getR(){
	    return row;
	}

	public void setR(int r){
	    row = r;
	}

	public void setC(int c){
	    col = c;
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
    private LNode<Coordinates> s;
    private Frontier<Coordinates> deck;

    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";	


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
    
    private class Frontier<T>{
	private MyDeque<T> deque = new MyDeque<T>();
	private boolean s;

	public Frontier (boolean stack){
	    s = stack;
	}

	public void add(T value){
	    deque.addFirst(value);
	}
	public T remove(){
	    if (s){
		return deque.removeFirst();
	    }else{
		return deque.removeLast();
	    }
	}

	public String toString(){
	    return deque.toString();
	}

	public int size(){
	    return deque.size();
	}
    }

    public String toString(boolean animate){
	if (animate){
	    return hide+go(0,0)+toString()+'\n'+show;
	}
	return toString();
    }
    
    public boolean solve(boolean animate){
	Coordinates start = new Coordinates(0,0);
	s = new LNode<Coordinates>(start);
	for (int i = 0; i < maze.length; i++){
	    for (int l = 0; l < maze[0].length; l++){
		if (maze[i][l] == 'S'){
		    start.setR(l);
		    start.setC(i);
		}
	    }
	}
	deck.add(start);
	LNode<Coordinates> a = new LNode<Coordinates>();
	Coordinates temp = new Coordinates(0,0);
	while (deck.size() > 0){
	    if (animate){
		System.out.println(toString(true));
		wait(1);
	    }
	    temp = deck.remove();
	    a.setNext(new LNode<Coordinates>(temp));
	    if (maze[temp.getC()][temp.getR()] == ' ' ||
		maze[temp.getC()][temp.getR()] == 'S'){
		maze[temp.getC()][temp.getR()] = '@';
		deck.add(new Coordinates(temp.getR(), temp.getC() + 1));
		deck.add(new Coordinates(temp.getR(), temp.getC() - 1));
		deck.add(new Coordinates(temp.getR() + 1, temp.getC()));
		deck.add(new Coordinates(temp.getR() - 1, temp.getC()));
	    }else if (maze[temp.getC()][temp.getR()] == 'E'){
		s = a;
		return true;
	    }else if (maze[temp.getC()][temp.getR()] == '@' ||
		      maze[temp.getC()][temp.getR()] == '#'){
		a = a.getNext();
	    }
	}
	s = a;
	return false;
    }

    public boolean solveDFS(boolean animate){
	deck = new Frontier<Coordinates>(true);
	return solve(animate);
    }

    public boolean solveBFS(boolean animate){
	deck = new Frontier<Coordinates>(false);
	return solve(animate);
    }

    public boolean solveBFS(){
	return solveBFS(false);
    }

    public boolean solveDFS(){
	return solveDFS(false);
    }

    public int[] solutionCoordinates(){
	System.out.println(s);
	while(s.getNext() != null){
	    System.out.println(s.getData());
	    s = s.getNext();
	}
	return new int[0];
    }
}
