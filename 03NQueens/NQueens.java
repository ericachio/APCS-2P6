import java.util.*;
import java.io.*;


public class NQueens{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    
    //instance variable
    private String[][]board;

    public String name(){
	return "chio.erica";
    }
    
    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "\n";
	//build your queens board here...
	for (int i = 0; i < board.length; i ++){
	    for (int j = 0; j < board[0].length; j++){
		ans += board[i][j] + "\t";
	    }
	    ans += "\n";
	}
	return hide + go(0,0) + ans + "\n" + show;
	//return ans;
    }
    
    public NQueens(int size){
	board = new String[size][size];
    }

    private String clear(){
	return  "[2J";
    }
    
    public void clearTerminal(){
	System.out.println(clear());
    }


    public void solve(){
	solve(0);
    }
    
    public boolean solve(int x){
	clearTerminal();
	System.out.println(this);
	wait(20);
	
	if (x >= board[0].length || x < 0 ){
	    return false;
	}
	for (int row = 0; row < board[row].length; row++){
	    if (board[x][row] == null){
		board[x][row] = "Q";
		if (solve(x + 1)){
		    return true;
		} 
		if (x == board[row].length - 1){
		    board[x][row] = "Q";
		    System.out.println(this);
		    return true;
		}
		
		board[x][row] = null;
	    }
	}
	return false;
    }
    
}
