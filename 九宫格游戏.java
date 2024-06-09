package hello;

import java.util.Scanner;

public class 九宫格游戏 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		final int SIZE = 3;
		int[][] board = new int[SIZE][SIZE];
		boolean gotResult = false;
		int numOfX = 0;
		int numOfO = 0;
				
        //读入矩阵
		for ( int i = 0; i<board.length; i++ )
		{
			for ( int j = 0; j<board[i].length; j++ )
			{
				board[i][j] = in.nextInt();
			}
		}
		
		//检查行
		if ( !gotResult )
		{
			for (int i = 0; i<board.length; i++ )
			{
				numOfX = 0;
				numOfO = 0;
				for ( int j = 0; j<board[i].length; j++ )
				{     
					if( board[i][j] == 1 )
					{
						numOfX ++;
					}
					else
					{
						numOfO ++;
					}
				}
				if ( numOfX == SIZE || numOfO == SIZE )
				{
					gotResult = true;
					break;
				}
			}
		}
        //检查列
		if ( !gotResult )
		{
			for( int j = 0; j<board.length; j++ ) 
			{
				numOfX = 0;
				numOfO = 0;
				for ( int i = 0; i<board[j].length; i++ )
				{
					if( board[j][i] == 1 )
					{
						numOfX ++;
					}
					else
					{
						numOfO++;
					}
				}
			}
		}
			if ( numOfX == SIZE || numOfO ==SIZE )
			{
				gotResult = true;
			}
			
            //检查正对角线
			for (int i = 0; i<board.length; i++ )
			{    
				numOfX = 0;
				numOfO = 0;
				if ( board[i][i] == 1 )
				{
					numOfX ++;
				}
				else
				{
					numOfO++;
				}
				if ( numOfX == SIZE || numOfO ==SIZE )
				{
					gotResult = true;
					break;
				}
			}
			
            //检查副对角线
			if ( !gotResult )
			{
				numOfX = 0;
				numOfO = 0;
				for( int i = 0; i<board.length; i++ ) 
				{
					if( board[i][SIZE-1-i]==1) 
					{
						numOfX ++;
					}
					else
					{
						numOfO++;
				    }
					if ( numOfX == SIZE || numOfO ==SIZE )
					{
						gotResult = true;
						break;
					}
				}
			}
		    if(gotResult)
		    {
		    	if(numOfX == SIZE)
		    	{
		    		System.out.println("O win");
		    	}
		    	else
		    	{
		    		System.out.println("X win");
		    	}
		    }
		    else 
		    {
		    	System.out.println("draw");
		    }

	}

}
