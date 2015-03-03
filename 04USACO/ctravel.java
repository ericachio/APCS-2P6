public class ctravel{

    public static int solve(int[] one, String[][] two, int[] three){
	int times = 0;
	return 0;
    }

    public static int helps(int[] one, String[][] field, int[] three){
	int x = three[0] - 1;
	int y = three[1] - 1;
	int endx = three[2] - 1;
	int endy = three[3] - 1;
	int time = one[2];

	int paths = 0;
	for (int i = time; i >= 0; i--){
	    paths += mazesolve(x, y, field, endx, endy, i); 
	}
	return paths;
    }

    public static int mazesolve(int x, int y, String[][] field, int endx, int endy, int t){
	int paths = 0;
	if (x == endx && y == endy){
	    return 1;
	}
	if (x >= field.length || x < 0 ||
	    y >= field[0].length || y < 0){
	    return 0;
	}
	if (t > 0){
	    // System.out.println(t);
	    if (field[x][y] == "."){
		field[x][y] = "_";
		//System.out.println(toString(field));
		paths += mazesolve(x, y - 1, field, endx, endy, t - 1);
		paths += mazesolve(x, y + 1, field, endx, endy, t - 1);
		paths += mazesolve(x + 1, y, field, endx, endy, t - 1);
		paths += mazesolve(x - 1, y, field, endx, endy, t - 1);
		/*
		if (mazesolve(x, y - 1, field, endx, endy, t - 1) ||
		    mazesolve(x - 1, y, field, endx, endy, t - 1) ||
		    mazesolve(x + 1, y, field, endx, endy, t - 1) ||
		    mazesolve(x, y + 1, field, endx, endy, t - 1)){
		    //System.out.println(t);
		    
		    return true;
		}
		if (x == endx && y == endy){
		    return true;
		}
		*/
		field[x][y] = ".";
	    }
	}
	//return false;
	return paths;
    }

    public static String toString(String[][] array){
	String ans = "";
	for (int i = 0; i < array.length; i++){
	    for (int j = 0; j < array[0].length; j++){
		ans+= array[i][j] + " ";
	    }
	    ans+= "\n";
	}
	return ans;
    }

    public static void main(String[]args){
	/*
	int[] one = {4,5,6};
	String[][] two = {{".",".",".","*","."},
			  {".",".",".","*","."},
			  {".",".",".",".","."},
			  {".",".",".",".","."}};
	int[] three = {1,3,1,5};
	*/
	int[] one = {5,5,14};
	String[][] two = {{".",".",".",".","*"},
			  {".",".",".",".","."},
			  {".",".","*",".","."},
			  {".",".",".",".","."},
			  {"*",".",".",".","."}};
	int[] three = {1,1,5,5};
	System.out.println(helps(one, two, three));
	//System.out.println(mazesolve(1,3, two, 1, 5, 6));
	//System.out.println(toString(two));
    }
}
