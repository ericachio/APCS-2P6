import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;

    public String name(){
	return "Chio.Erica";
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
	//build your knights tour here...
	for (int i = 0; i < board.length; i ++){
	    for (int j = 0; j < board[0].length; j++){
		ans += board[i][j] + "\t";
	    }
	    ans += "\n";
	}
	return hide + go(0,0) + ans + "\n" + show;
	//return ans;
    }
    
    public KnightsTour(int size){
	board = new int[size][size];
    }

    private String clear(){
	return  "[2J";
    }
    
    public void clearTerminal(){
	System.out.println(clear());
    }


    public void solve(){
	solve(0,0);
    }

    public boolean solve(int startx, int starty){
	board[startx][starty] = 0;
	return solve(startx, starty, 1);	
    }
    
    public boolean solve(int x,int y,int currentMoveNumber){
	//clearTerminal();
	//System.out.println(this);
	//wait(20);
	
	if (x >= board[0].length || y >= board.length ||
	    x < 0 || y < 0){
	    return false;
	}

	if (currentMoveNumber == (board.length * board.length) + 1){
	    board[x][y] = currentMoveNumber;
	    System.out.println(this);
	    return true;
	}
	
	if (board[x][y] == 0){
	    board[x][y] = currentMoveNumber;
	    if (solve(x + 1, y + 2, currentMoveNumber + 1) ||
		solve(x - 1, y + 2, currentMoveNumber + 1) ||
		solve(x + 2, y + 1, currentMoveNumber + 1) ||
		solve(x + 2, y - 1, currentMoveNumber + 1) ||
		solve(x - 1, y - 2, currentMoveNumber + 1) ||
		solve(x + 1, y - 2, currentMoveNumber + 1) ||
		solve(x - 2, y - 1, currentMoveNumber + 1) ||
		solve(x - 2, y + 1, currentMoveNumber + 1)){
		return true;
	    }
	    board[x][y] = 0;
	}
	return false;
	
	
    }
    
}
