public class Driver{

    //for mazesolver
    /*
    public static void main(String[]args){
	Mazesolver f;
	if(args.length < 1){
	    f = new Mazesolver("data1.dat");
	}else{
	    f = new Mazesolver(args[0]);
	}
	f.clearTerminal();
	f.solve();
				
    }
    
    //KnightsTour
    public static void main(String[] args){
	KnightsTour a;
	if (args.length < 1){
	    a = new KnightsTour(6);
	}else{
	    a = new KnightsTour(Integer.parseInt(args[0]));
	}
	//a.clearTerminal();
	a.solve();
					    
    }
    */
    public static void main(String[]args){
	NQueens b;
	b = new NQueens(4);
	b.clearTerminal();
	b.solve();
    }
    

}
