public class Maze{

    public static char[][] solvem(char[][] maze){
	char[][] copy = maze;
	int x,y;
	for (int i = 0; i < maze.length; i++){
	    for (int j = 0; j < maze[i].length; j++){
		if (maze[i][j] == 'S'){
		    x = j;
		    y = i;
		}
	    }
	}
	return copy;
    }

}
