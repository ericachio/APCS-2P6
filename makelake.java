public class makelake{
    
    public static int lake(int[] one, int[][] two, int[] three, int[] four){
	
    }

    public static int findMax(int[][] array, int startRow, int startCol, int endRow, int endCol){
	int max = array[startRow][startCol];
	for (int i = startRow; i <= endRow; i++){
	    for (int j = startCol; j <= endCol; j++){
		if (array[i][j] >= max){
		    max = array[i][j];
		}
	    }
	}
	return max;
    }

    public static int[][] directions(int[] instructions){
	int startRow = instructions[0];
	int startCol = instructions[1];
	
	
    }
}
