package game;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import database.Database;


public class Monster {
	
	 private static int X;
	 private static int Y;
	 private static int state;
	 	 
	 public Monster(int i, int j) {
		 	
		 	X = i;
	        Y = j;
	        state = 0;
	    }
	 
	public static void move()
	{
		int tempX = X;
		int tempY = Y;
		
		int x = (int) (Math.random()*Database.getObjects().length);
		int y = (int) (Math.random()*Database.getObjects().length);
		
		if (Database.getObjects()[tempX][tempY] == 13 && Database.getObjects()[x][y] == 0)
			{
				X = x;
				Y = y;
				Database.getObjects()[tempX][tempY] = 0;
				Database.getObjects()[X][Y] = 13;
			}
		
	}		
	
	public static int getX()
	{
		return X;
	}
}
