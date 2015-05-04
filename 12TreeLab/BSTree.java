//
//
//Your binary search tree skeleton file:


import java.io.*;
import java.util.*;

public class BSTree <T extends Comparable>{

    private BSTreeNode<T> root;

    public BSTree() {
	root = null;
    }

    public boolean isEmpty() {
	return root == null;
    }
    public boolean isLeaf( BSTreeNode<T> t ) {
	return (t.getLeft() == null && t.getRight() == null);
    }

    /*======== public void add() ==========
      Inputs:   T c  
      Returns: 

      Wrapper for the recursive add method
      ====================*/
    public void add( T c ) {
	root = add( root, new BSTreeNode<T>(c) );
    }

    /*======== public BSTreeNode<T> add() ==========
      Inputs:  BSTreeNode<T> curr
               BSTreeNode<T> t 
      Returns: 

      Add t to the correct place in the tree rooted at curr.
      ====================*/
    private BSTreeNode<T> add(BSTreeNode<T> curr, BSTreeNode<T> t) {
	if (root == null){
	    return t;
	}else if(((T)t.getData()).compareTo((T)curr.getData()) > 0){
	    curr.setRight(add(curr.getRight(),t));
	}else if(t.getData().compareTo(curr.getData()) < 0){
	    curr.setLeft(add(curr.getLeft(),t));
	}
	return null;
	//return getValue.compareTo(getValue of other node)
    }

    /*======== public void remove() ==========
      Inputs:   T c  
      Returns: 
      
      Wrapper for the recursive remove method
      ====================*/
    public void remove( T c ) {
	root = remove( root, c );
    }

    /*======== public BSTreeNode<T> remove() ==========
      Inputs:   BSTreeNode<T> curr
		T c
      Returns: 

      Should remove the value c from the tree rooted at
      curr, if it exists.
      ====================*/
    private BSTreeNode<T> remove( BSTreeNode<T> curr, T c ) {
	Rand rand = new Random();
	if (curr.getData() == c){
	    int side = rand.nextInt(2) + 1;
	    if (side == 0){
		//smallest of the right side
		while (curr.getData != null){
		    curr = curr.getRight;
		}
		curr.setData(curr.getLeft());
	    }else if (side == 1){
		//smallest of the left side
		curr.setData(curr.getRight());
	    }
	    
	}
	return null;
    }


    /*======== public void inOrder()) ==========
      Inputs:   
      Returns: 

      Wrapper for the recursive inOrder method
      ====================*/
    public void inOrder() {
	inOrderHelper( root );
	System.out.println();
    }

    /*======== public void inOrderHelper() ==========
      Inputs:   BSTreeNode<T> t  
      Returns: 
      
      Performs an in-order traversal for the tree with 
      root t.
      ====================*/
    public void inOrderHelper( BSTreeNode<T> t ) {
	if (t == null) 
	    return;
	inOrderHelper( t.getLeft() );
	System.out.print( t.getData() + " ");
	inOrderHelper( t.getRight() );
    }

    public String toString() {
	if (root == null)
	    return "";
	String result = "";
	int height = getHeight();
	int wordLength = maxLength();
	// add the every level of the tree except the last one
	for (int level = 1; level < height; level++){
	    // remove extra spaces from the end of each level's 
	    // String to prevent lines from getting unnecessarily 
	    // long and add spaces to the front of each level's String
	    // to keep everything centered
	    result += spaces(wordLength * Math.pow(2, height - level) - wordLength) + getLevel(root, level, level, height, wordLength).replaceFirst("\\s+$", "") + "\n";
	}
	// now add the last level (level = height)
	result += getLevel(root, height, height, height, wordLength).replaceFirst("\\s+$", "");
	
	return result;
    }
   
    public static void main( String[] args ) {

    }

}
